package com.nugurang.graphql.mutation;

import com.nugurang.dto.EventDto;
import com.nugurang.dto.EventInputDto;
import com.nugurang.service.EventService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventMutation implements GraphQLMutationResolver {

    private final EventService eventService;

    public EventDto createEvent(EventInputDto eventInputDto) {
        return eventService.createEvent(eventInputDto).toDto();
    }


    public EventDto updateEvent(EventInputDto eventInputDto, Long eventId) {
        return eventService.updateEvent(eventInputDto, eventId).toDto();
    }

    public Long deleteEvent(Long eventId) {
        eventService.deleteEvent(eventId);
        return eventId;
    }
}
