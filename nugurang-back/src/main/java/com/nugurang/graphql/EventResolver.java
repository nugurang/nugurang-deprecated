package com.nugurang.graphql;

import com.nugurang.dao.ImageDao;
import com.nugurang.dto.EventDto;
import com.nugurang.dto.ImageDto;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EventResolver implements GraphQLResolver<EventDto> {
    private final ImageDao imageDao;

    public List<ImageDto> images(EventDto eventDto) {
        return null;
    }
}
