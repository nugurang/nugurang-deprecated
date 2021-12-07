package com.nugurang.controller;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
//import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HomeController {
    private final OAuth2AuthorizedClientService authorizedClientService;

    @RequestMapping("/")
    public String index() {
        Authentication auth = SecurityContextHolder
            .getContext()
            .getAuthentication();

        Object principal = auth.getPrincipal();

        OAuth2AuthenticationToken oauth2 = (OAuth2AuthenticationToken) auth;

        OAuth2AuthorizedClient client = authorizedClientService.loadAuthorizedClient(
            oauth2.getAuthorizedClientRegistrationId(),
            oauth2.getName()
        );
        OAuth2User oauth2User = oauth2.getPrincipal();
        Map<String, Object> attributes = oauth2User.getAttributes();
        for (Map.Entry<String, Object> entry : attributes.entrySet()) {
            System.out.println(entry.getKey());
        }
        String name = String.valueOf(attributes.get("login"));
        String email = String.valueOf(attributes.get("email"));

        /*
        String name = (String) (
            (Map) (
                (Map) oauth2User
                .getAttribute("kakao_account")
            )
            .get("profile")
        ).get("nickname");
        */
        /*
        if (client == null) {
            return "authorized client is null "
                + oauth2.getAuthorizedClientRegistrationId()
                + " " + oauth2.getName() + " " + name;
        }
        OAuth2AccessToken accessToken = client.getAccessToken();
        return client.getPrincipalName()
            + " " + accessToken
            + " " + oauth2.getAuthorizedClientRegistrationId()
            + " " + authentication.getName() + " " + name + " " + email;
        */
        return String.join(
            "<br/>",
            oauth2.getAuthorizedClientRegistrationId(),
            oauth2.getName(),
            name,
            email,
            principal.toString(),
            String.valueOf(principal instanceof UserDetails),
            String.valueOf(principal instanceof OAuth2User),
            auth.getDetails().toString()
        );
    }
}
