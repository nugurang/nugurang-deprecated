package com.nugurang.service;

import com.nugurang.dto.SigninRequestDto;
import java.time.Instant;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizationContext;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuth2SigninService {
    private final OAuth2AuthorizedClientService oauth2AuthorizedClientService;
    private final ClientRegistrationRepository clientRegistrationRepository;
    private final OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2UserService = new DefaultOAuth2UserService();
    private final AuthenticationDetailsSource<HttpServletRequest, ?> authenticationDetailsSource = new WebAuthenticationDetailsSource();

    public Authentication signin(HttpServletRequest request, SigninRequestDto signinRequestDto) throws AuthenticationException {
        final var accessToken = new OAuth2AccessToken(
            OAuth2AccessToken.TokenType.BEARER,
            signinRequestDto.getAccessToken().getTokenValue(),
            Instant.now(),
            Instant.MAX,
            signinRequestDto.getAccessToken().getScopes()
        );

        final var refreshToken = new OAuth2RefreshToken(
            signinRequestDto.getRefreshToken().getTokenValue(),
            Instant.now(),
            Instant.MAX
        );

        final var clientRegistrationId = signinRequestDto.getClientRegistrationId();
        final var clientRegistration = clientRegistrationRepository.findByRegistrationId(clientRegistrationId);
        final var additionalParameters = new HashMap<String, Object>();
        final var oauth2User = oauth2UserService.loadUser(new OAuth2UserRequest(clientRegistration, accessToken, additionalParameters));
        final var oauth2AuthenticationToken = new OAuth2AuthenticationToken(oauth2User, oauth2User.getAuthorities(), clientRegistrationId);
        final var oauth2AuthorizedClient = new OAuth2AuthorizedClient(clientRegistration, oauth2User.getName(), accessToken, refreshToken);
        oauth2AuthorizedClientService.saveAuthorizedClient(oauth2AuthorizedClient, oauth2AuthenticationToken);
        oauth2AuthenticationToken.setDetails(authenticationDetailsSource.buildDetails(request));
        /*
        SecurityContextHolder
                .getContext()
                .setAuthentication(oauth2AuthenticationToken);*/

        return oauth2AuthenticationToken;
    }

    public void refresh() {
        final var oauth2AuthenticationToken = (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        var oauth2AuthorizedClient = oauth2AuthorizedClientService.loadAuthorizedClient(
            oauth2AuthenticationToken.getAuthorizedClientRegistrationId(),
            oauth2AuthenticationToken.getPrincipal().getName()
        );
        final var oauth2AuthorizationContext = OAuth2AuthorizationContext
            .withAuthorizedClient(oauth2AuthorizedClient)
            .principal(oauth2AuthenticationToken)
            .build();
        final var oauth2AuthorizedClientProvider = OAuth2AuthorizedClientProviderBuilder.builder().refreshToken().build();
        oauth2AuthorizedClient = oauth2AuthorizedClientProvider.authorize(oauth2AuthorizationContext);
        oauth2AuthorizedClientService.saveAuthorizedClient(oauth2AuthorizedClient, oauth2AuthenticationToken);
        //DefaultRefreshTokenTokenResponseClient?
    }
}
