package com.nugurang.graphql;

import com.nugurang.dao.NotificationDao;
import com.nugurang.dto.NotificationDto;
import com.nugurang.dto.NotificationTypeDto;
import com.nugurang.dto.UserDto;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NotificationResolver implements GraphQLResolver<NotificationDto> {
    NotificationDao notificationDao;

    public UserDto user(NotificationDto notificationDto) {
        return notificationDao
            .findById(notificationDto.getId())
            .get()
            .getUser()
            .toDto();
    }

    public NotificationTypeDto type(NotificationDto notificationDto) {
        return notificationDao
            .findById(notificationDto.getId())
            .get()
            .getNotificationType()
            .toDto();
    }
}
