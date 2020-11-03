package com.nugurang.graphql;

import com.nugurang.dto.NotificationDto;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NotificationResolver implements GraphQLResolver<NotificationDto> {

}
