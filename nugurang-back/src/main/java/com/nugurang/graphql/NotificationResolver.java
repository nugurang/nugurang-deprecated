package com.nugurang.graphql;

import com.nugurang.dao.ArticleDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dto.ArticleDto;
import com.nugurang.dto.NotificationDto;
import com.nugurang.dto.TeamDto;
import com.nugurang.dto.UserDto;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NotificationResolver implements GraphQLResolver<NotificationDto> {

    private final UserDao userDao;
    private final ArticleDao articleDao;

    public UserDto user(NotificationDto notificationDto) {
        return null;
    }

    public ArticleDto article(NotificationDto notificationDto) {
        return null;
    }

    public TeamDto team(NotificationDto notificationDto) {
        return null;
    }
}
