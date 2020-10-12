package com.nugurang.graphql;

import com.nugurang.dao.ArticleDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dto.ArticleDto;
import com.nugurang.dto.StarDto;
import com.nugurang.dto.UserDto;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StarResolver implements GraphQLResolver<StarDto> {

    private final UserDao userDao;
    private final ArticleDao articleDao;

    public UserDto user(StarDto starDto) {
        return null;
    }

    public ArticleDto article(StarDto starDto) {
        return null;
    }

}
