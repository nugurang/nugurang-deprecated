package com.nugurang.oauth2;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class OAuth2RestAuthenticationProvider implements AuthenticationProvider {

    private final OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2UserService = new DefaultOAuth2UserService();
    private GrantedAuthoritiesMapper authoritiesMapper = ((authorities) -> authorities);

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        OAuth2RestAuthenticationToken oauth2RestAuthenticationToken = (OAuth2RestAuthenticationToken) authentication;

        OAuth2User oauth2User = this.oauth2UserService.loadUser(new OAuth2UserRequest(
            oauth2RestAuthenticationToken.getClientRegistration(),
            oauth2RestAuthenticationToken.getAccessToken(),
            oauth2RestAuthenticationToken.getAdditionalParameters()
        ));

        return new OAuth2RestAuthenticationToken(
            this.authoritiesMapper.mapAuthorities(oauth2User.getAuthorities()),
            oauth2RestAuthenticationToken.getClientRegistration(),
            oauth2RestAuthenticationToken.getAccessToken(),
            oauth2RestAuthenticationToken.getRefreshToken(),
            oauth2RestAuthenticationToken.getAdditionalParameters(),
            oauth2User
        );
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return OAuth2RestAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
