package com.nugurang.graphql.query;

import com.nugurang.dto.NotificationDto;
import com.nugurang.service.NotificationService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationQuery implements GraphQLQueryResolver {

    private final NotificationService notificationService;

    public Optional<NotificationDto> getNotification(Long id) {
        return notificationService.getNotification(id).map((entity) -> entity.toDto());
    }
}
