package com.nugurang.oauth2;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;
import org.springframework.security.oauth2.core.user.OAuth2User;

@Getter
@Setter
class OAuth2RestAuthenticationToken extends AbstractAuthenticationToken {

    private ClientRegistration clientRegistration;
    private OAuth2AccessToken accessToken;
    private OAuth2RefreshToken refreshToken;
    private Map<String, Object> additionalParameters;
    private OAuth2User principal;

    @Builder
    public OAuth2RestAuthenticationToken(
            Collection<? extends GrantedAuthority> authorities,
            ClientRegistration clientRegistration,
            OAuth2AccessToken accessToken,
            OAuth2RefreshToken refreshToken,
            Map<String, Object> additionalParameters,
            OAuth2User principal
    ) {
        super(authorities);
        this.clientRegistration = clientRegistration;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.additionalParameters = additionalParameters;
        this.principal = principal;
        this.setAuthenticated(true);
    }

    @Builder
    public OAuth2RestAuthenticationToken(
            ClientRegistration clientRegistration,
            OAuth2AccessToken accessToken,
            OAuth2RefreshToken refreshToken,
            Map<String, Object> additionalParameters
    ) {
        this(Collections.emptyList(), clientRegistration, accessToken, refreshToken, additionalParameters, null);
        this.setAuthenticated(false);
    }

    @Override
    public Object getCredentials() {
        return "";
    }

    @Override
    public OAuth2User getPrincipal() {
        return this.principal;
    }
}