package com.nugurang.graphql;

import com.nugurang.dao.ArticleDao;
import com.nugurang.dao.ThreadDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dto.ArticleDto;
import com.nugurang.dto.ThreadDto;
import com.nugurang.dto.UserDto;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArticleResolver implements GraphQLResolver<ArticleDto> {

    private final UserDao userDao;
    private final ThreadDao threadDao;
    private final ArticleDao articleDao;

    public ThreadDto thread(ArticleDto articleDto) {
        return articleDao.findById(articleDto.getId())
            .map((articleEntity) -> articleEntity.getThread())
            .map((entity) -> entity.toDto())
            .get();
    }

    public UserDto user(ArticleDto articleDto) {
        return articleDao
            .findById(articleDto.getId())
            .map((articleEntity) -> articleEntity.getUser())
            .map((userEntity) -> userEntity.toDto())
            .get();
    }

    public Optional<ArticleDto> parent(ArticleDto articleDto) {
        return articleDao
            .findById(articleDto.getId())
            .map((articleEntity) -> articleEntity.getParent())
            .map((entity) -> entity.toDto());
    }
}
