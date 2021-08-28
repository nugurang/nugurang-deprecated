package com.nugurang.graphql;

import com.nugurang.dao.ImageDao;
import com.nugurang.dao.MatchRequestDao;
import com.nugurang.dto.EventDto;
import com.nugurang.dto.ImageDto;
import com.nugurang.dto.MatchRequestDto;
import com.nugurang.dto.TagDto;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EventQuery implements GraphQLResolver<EventDto> {
    private final ImageDao imageDao;
    private final MatchRequestDao matchRequestDao;

    public List<ImageDto> images(EventDto eventDto) {
        return null;
    }

    public List<TagDto> tags(EventDto eventDto) {
        return null;
    }

    public List<MatchRequestDto> matchRequests(EventDto eventDto) {
        return matchRequestDao
            .findAllByEventId(eventDto.getId())
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }
}
