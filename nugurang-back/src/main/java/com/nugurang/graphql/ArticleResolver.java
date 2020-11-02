package com.nugurang.graphql;

import com.nugurang.dao.ArticleDao;
import com.nugurang.dao.ImageDao;
import com.nugurang.dao.ThreadDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dto.ArticleDto;
import com.nugurang.dto.ImageDto;
import com.nugurang.dto.ThreadDto;
import com.nugurang.dto.UserDto;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArticleResolver implements GraphQLResolver<ArticleDto> {

    private final ArticleDao articleDao;
    private final ImageDao imageDao;
    private final ThreadDao threadDao;
    private final UserDao userDao;


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

    public List<ImageDto> images(ArticleDto articleDto) {
        return imageDao
            .findAllByArticleId(articleDto.getId())
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }
}
