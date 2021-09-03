package com.nugurang.graphql.query;

import com.nugurang.dto.EventDto;
import com.nugurang.service.EventService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventQuery implements GraphQLQueryResolver {

    private final EventService eventService;

    public Optional<EventDto> getEvent(Long id) {
        return eventService.getEvent(id).map((entity) -> entity.toDto());
    }
}
