package com.nugurang.nugurang;

import com.nugurang.entity.Article;
import com.nugurang.repository.ArticleRepository;
import java.util.LinkedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    ArticleRepository articleRepository;

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
        return "Hello Spring Boot";
    }
}
