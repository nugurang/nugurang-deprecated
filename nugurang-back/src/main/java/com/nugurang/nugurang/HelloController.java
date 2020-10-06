package com.nugurang.nugurang;

import com.nugurang.entity.Article;
import com.nugurang.repository.ArticleRepository;
import java.util.LinkedList;
import java.util.HashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HelloController {
    private final ArticleRepository articleRepository;
    private final OAuth2AuthorizedClientService authorizedClientService;


    @RequestMapping("/")
    public String index() {
        /*
        articleRepository.save(new Article("test", "this is test article"));
        Iterable<Article> articles = articleRepository.findAll();
        LinkedList<String> strings = new LinkedList<>();
        for (Article article : articles) {
            String title = article.getTitle();
            strings.add(title == null ? "" : title);
        }
        return "Hello Spring Boot<br/>" + String.join("<br/>", strings);
        */
        OAuth2AuthenticationToken authentication = (OAuth2AuthenticationToken) SecurityContextHolder
            .getContext()
            .getAuthentication();

        OAuth2AuthorizedClient client = authorizedClientService.loadAuthorizedClient(
            authentication.getAuthorizedClientRegistrationId(),
            authentication.getName()
        );
        OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();
        String id = String.valueOf(oauth2User.getAttributes().get("id"));
        String name = (String) (
            (HashMap) (
                (HashMap) oauth2User
                .getAttribute("kakao_account")
            )
            .get("profile")
        ).get("nickname");

         if (client == null) {
            return "authorized client is null "
                + authentication.getAuthorizedClientRegistrationId()
                + " " + authentication.getName() + " " + name;
        }
        return client.getPrincipalName()
            + " "
            + authentication.getAuthorizedClientRegistrationId()
            + " " + authentication.getName() + " " + name;
    }
}
