package com.nugurang.graphql.query;

import com.nugurang.dto.ArticleDto;
import com.nugurang.service.ArticleService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleQuery implements GraphQLQueryResolver {

    private final ArticleService articleService;

    public Optional<ArticleDto> getArticle(Long id) {
        return articleService.getArticle(id).map((entity) -> entity.toDto());
    }
}
