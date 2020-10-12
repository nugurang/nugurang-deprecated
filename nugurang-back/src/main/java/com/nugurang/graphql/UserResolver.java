package com.nugurang.graphql;

import com.nugurang.dao.ArticleDao;
import com.nugurang.dao.BoardDao;
import com.nugurang.dao.ImageDao;
import com.nugurang.dao.NotificationDao;
import com.nugurang.dao.ThreadDao;
import com.nugurang.dto.ArticleDto;
import com.nugurang.dto.BoardDto;
import com.nugurang.dto.ImageDto;
import com.nugurang.dto.NotificationDto;
import com.nugurang.dto.ThreadDto;
import com.nugurang.dto.UserDto;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserResolver implements GraphQLResolver<UserDto> {
    private final ImageDao imageDao;
    private final BoardDao boardDao;
    private final ThreadDao threadDao;
    private final ArticleDao articleDao;
    private final NotificationDao notificationDao;

    public ImageDto image(UserDto userDto) {
        return null;
    }

    public Optional<BoardDto> blog(UserDto userDto) {
        return Optional.empty();
    }

    public List<ThreadDto> threads(UserDto userDto, int page, int pageSize) {
        return null;
    }

    public List<ArticleDto> articles(UserDto userDto, int page, int pageSize) {
        return null;
    }

    public List<UserDto> followings(UserDto userDto, int page, int pageSize) {
        return null;
    }

    public List<UserDto> followers(UserDto userDto, int page, int pageSize) {
        return null;
    }

    public List<NotificationDto> notifications(UserDto userDto) {
        return null;
    }
}
