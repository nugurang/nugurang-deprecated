package com.nugurang.controller;

import com.nugurang.dao.ArticleDao;
import com.nugurang.entity.ArticleEntity;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HomeController {
    private final ArticleDao articleDao;
    private final OAuth2AuthorizedClientService authorizedClientService;

    @RequestMapping("/")
    public String index() {
        OAuth2AuthenticationToken authentication = (OAuth2AuthenticationToken) SecurityContextHolder
            .getContext()
            .getAuthentication();

        OAuth2AuthorizedClient client = authorizedClientService.loadAuthorizedClient(
            authentication.getAuthorizedClientRegistrationId(),
            authentication.getName()
        );
        OAuth2User oauth2User = authentication.getPrincipal();
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
                + authentication.getAuthorizedClientRegistrationId()
                + " " + authentication.getName() + " " + name;
        }
        OAuth2AccessToken accessToken = client.getAccessToken();
        return client.getPrincipalName()
            + " " + accessToken
            + " " + authentication.getAuthorizedClientRegistrationId()
            + " " + authentication.getName() + " " + name + " " + email;
        */
        return authentication.getAuthorizedClientRegistrationId()
            + " " + authentication.getName() + " " + name + " " + email;

    }

    @RequestMapping("/after-signin")
    public void afterLogin(
        HttpServletResponse response,
        @CookieValue("JSESSIONID") String jsessionId) throws IOException {
        response.sendRedirect("http://localhost:3000/after-signin/" + jsessionId);
    }
}
