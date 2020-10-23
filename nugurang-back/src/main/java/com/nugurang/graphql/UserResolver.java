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
import com.nugurang.dto.UserHonorDto;
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

    public Integer totalHonor(UserDto userDto) {
        return 0;
    }

    public List<UserHonorDto> honors(UserDto userDto) {
        return null;
    }

    public ImageDto image(UserDto userDto) {
        return null;
    }

    public Optional<BoardDto> blog(UserDto userDto) {
        return Optional.empty();
    }

    public List<ThreadDto> getThreads(UserDto userDto, Integer page, Integer pageSize) {
        return null;
    }

    public List<ArticleDto> getArticles(UserDto userDto, Integer page, Integer pageSize) {
        return null;
    }

    public List<UserDto> getFollowings(UserDto userDto, Integer page, Integer pageSize) {
        return null;
    }

    public List<UserDto> getFollowers(UserDto userDto, Integer page, Integer pageSize) {
        return null;
    }

    public List<NotificationDto> getNotifications(UserDto userDto, Integer page, Integer pageSize) {
        return null;
    }
}
