package com.nugurang.oauth2;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nugurang.dto.SigninRequestDto;
import com.nugurang.http.MultiReadableHttpServletRequest;
import java.io.IOException;
import java.time.Instant;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Slf4j
public class OAuth2RestAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private static final String DEFAULT_FILTER_PROCESSES_URL = "/signin";
    private static final String CLIENT_REGISTRATION_NOT_FOUND_ERROR_CODE = "client_registration_not_found";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

    @Autowired
    private OAuth2AuthorizedClientService oauth2AuthorizedClientService;

    public OAuth2RestAuthenticationFilter() {
        super(new AntPathRequestMatcher(DEFAULT_FILTER_PROCESSES_URL, "POST"));
    }

    public OAuth2RestAuthenticationFilter(String filterProcessesUrl) {
        super(new AntPathRequestMatcher(filterProcessesUrl, "POST"));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        super.doFilter(new MultiReadableHttpServletRequest((HttpServletRequest) request), response, chain);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
        throws AuthenticationException, IOException, ServletException {
        SigninRequestDto signinRequestDto = null;
        try {
            signinRequestDto = objectMapper.readValue(request.getInputStream().readAllBytes(), SigninRequestDto.class);
            log.info(signinRequestDto.getAccessToken().getIssuedAt().toString());
        } catch (JsonMappingException jme) {
            log.error(jme.getMessage());
            throw new BadCredentialsException("Bad credentials", jme);
        }

        final var registrationId = signinRequestDto.getClientRegistrationId();
        final var clientRegistration = clientRegistrationRepository.findByRegistrationId(registrationId);
        if (clientRegistration == null) {
            OAuth2Error oauth2Error = new OAuth2Error(CLIENT_REGISTRATION_NOT_FOUND_ERROR_CODE,
                    "Client Registration not found with Id: " + registrationId, null);
            throw new OAuth2AuthenticationException(oauth2Error, oauth2Error.toString());
        }

        final var oauth2AccessToken = new OAuth2AccessToken(
                OAuth2AccessToken.TokenType.BEARER,
                signinRequestDto.getAccessToken().getTokenValue(),
                Instant.now(),
                Instant.MAX,
                signinRequestDto.getAccessToken().getScopes()
        );

        final var oauth2RefreshToken = new OAuth2RefreshToken(
                signinRequestDto.getRefreshToken().getTokenValue(),
                Instant.now(),
                Instant.MAX
        );

        final var additionalParameters = signinRequestDto.getAdditionalParameters();

        final var authenticationDetails = this.authenticationDetailsSource.buildDetails(request);

        final var oauth2RestAuthenticationToken = (OAuth2RestAuthenticationToken) this.getAuthenticationManager().authenticate(
            new OAuth2RestAuthenticationToken(
                clientRegistration, oauth2AccessToken, oauth2RefreshToken, additionalParameters
            )
        );

        final var oauth2AuthenticationToken = new OAuth2AuthenticationToken(
                oauth2RestAuthenticationToken.getPrincipal(),
                oauth2RestAuthenticationToken.getAuthorities(),
                oauth2RestAuthenticationToken.getClientRegistration().getRegistrationId()
        );
        oauth2AuthenticationToken.setDetails(authenticationDetails);

        final var oauth2AuthorizedClient = new OAuth2AuthorizedClient(
                oauth2RestAuthenticationToken.getClientRegistration(), oauth2AuthenticationToken.getName(),
                oauth2RestAuthenticationToken.getAccessToken(), oauth2RestAuthenticationToken.getRefreshToken());
        this.oauth2AuthorizedClientService.saveAuthorizedClient(oauth2AuthorizedClient, oauth2AuthenticationToken);

        return oauth2AuthenticationToken;
    }
}
