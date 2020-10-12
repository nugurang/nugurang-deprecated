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
    private final ArticleDao parentDao;

    public ThreadDto thread(ArticleDto articleDto) {
        /*return threadDao.findByArticle_Id(articleDto.getId())
            .map((threadEntity) ->
                ThreadDto.builder()
                .id(threadEntity.getId())
                .name(threadEntity.getName())
                .build()
            );*/
        return null;
    }

    public UserDto user(ArticleDto articleDto) {
        /*return userDao.findByArticleId(articleDto.getId())
            .map((userEntity) ->
                UserDto.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .biography(userEntity.getBiography())
                .build()
            );*/
        return null;
    }

    public Optional<ArticleDto> parent(ArticleDto articleDto) {
        //return articleDao.findById(article.getParentId());
        return Optional.empty();
    }

}
