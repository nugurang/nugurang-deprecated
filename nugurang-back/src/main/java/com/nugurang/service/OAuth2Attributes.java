package com.nugurang.service;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuth2Attributes {

    private final OAuth2AuthorizedClientService authorizedClientService;

    private OAuth2AuthenticationToken getOAuth2AuthToken() {
        OAuth2AuthenticationToken oauth2AuthToken = (OAuth2AuthenticationToken)
            SecurityContextHolder
            .getContext()
            .getAuthentication();
        return oauth2AuthToken;
    }

    private OAuth2AuthorizedClient getOAuth2Client() {
        OAuth2AuthenticationToken oauth2AuthToken = getOAuth2AuthToken();
        return authorizedClientService.loadAuthorizedClient(
            oauth2AuthToken.getAuthorizedClientRegistrationId(),
            oauth2AuthToken.getName()
        );
    }

    private OAuth2User getOAuth2User() {
        return getOAuth2AuthToken().getPrincipal();
    }

    private Map<String, Object> getOAuth2Attributes() {
        OAuth2User oauth2User = getOAuth2User();
        return oauth2User.getAttributes();
    }

    public String getProvider() {
        OAuth2AuthenticationToken oauth2AuthToken = getOAuth2AuthToken();
        return oauth2AuthToken.getAuthorizedClientRegistrationId();
    }

    public String getId() {
        OAuth2AuthenticationToken oauth2AuthToken = getOAuth2AuthToken();
        return oauth2AuthToken.getName();
    }

    public String getName() {
        Map<String, Object> oauth2Attributes = getOAuth2Attributes();
        return (String) oauth2Attributes.get("login");
    }

    public String getEmail() {
        Map<String, Object> oauth2Attributes = getOAuth2Attributes();
        return (String) oauth2Attributes.get("email");
    }
}
