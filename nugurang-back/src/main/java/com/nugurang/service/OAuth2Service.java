package com.nugurang.service;

import java.util.Map;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Builder
@Data
class OAuth2Attributes {
    @NotNull
    private String name;
    @NotNull
    private String email;

    public static OAuth2Attributes ofGithub(Map<String, Object> oauth2Attributes) {
        return OAuth2Attributes
            .builder()
            .name((String) oauth2Attributes.get("login"))
            .email((String) oauth2Attributes.get("email"))
            .build();
    }

    public static OAuth2Attributes ofKakao(Map<String, Object> oauth2Attributes) {
        Map<String, Object> account = (Map<String, Object>) oauth2Attributes.get("kakao_account");
        Map<String, Object> profile = (Map<String, Object>) account.get("profile");
        return OAuth2Attributes
            .builder()
            .name((String) profile.get("nickname"))
            .email((String) account.get("email"))
            .build();
    }
}

@Service
@RequiredArgsConstructor
public class OAuth2Service {

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

    private OAuth2Attributes getOAuth2Attributes() {
        OAuth2User oauth2User = getOAuth2User();
        Map<String, Object> oauth2Attributes = oauth2User.getAttributes();
        switch (getProvider()) {
        case "github":
            return OAuth2Attributes.ofGithub(oauth2Attributes);
        case "kakao":
            return OAuth2Attributes.ofKakao(oauth2Attributes);
        default:
            return null;
        }
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
        OAuth2Attributes oauth2Attributes = getOAuth2Attributes();
        return oauth2Attributes.getName();
    }

    public String getEmail() {
        OAuth2Attributes oauth2Attributes = getOAuth2Attributes();
        return oauth2Attributes.getEmail();
    }
}
