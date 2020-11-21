package com.nugurang.graphql;

import com.nugurang.dao.MatchRequestDao;
import com.nugurang.dto.EventDto;
import com.nugurang.dto.MatchRequestDto;
import com.nugurang.dto.UserDto;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MatchRequestResolver implements GraphQLResolver<MatchRequestDto> {
    private final MatchRequestDao matchRequestDao;

    public EventDto event(MatchRequestDto matchRequestDto) {
        return matchRequestDao
            .findById(matchRequestDto.getId())
            .get()
            .getEvent()
            .toDto();
    }

    public UserDto user(MatchRequestDto matchRequestDto) {
        return matchRequestDao
            .findById(matchRequestDto.getId())
            .get()
            .getUser()
            .toDto();
    }
}
