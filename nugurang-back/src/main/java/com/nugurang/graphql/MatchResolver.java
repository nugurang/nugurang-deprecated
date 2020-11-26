package com.nugurang.graphql;

import com.nugurang.dao.MatchDao;
import com.nugurang.dto.EventDto;
import com.nugurang.dto.MatchDto;
import com.nugurang.dto.MatchTypeDto;
import com.nugurang.dto.TeamDto;
import com.nugurang.dto.UserDto;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MatchResolver implements GraphQLResolver<MatchDto> {
    private final MatchDao matchDao;

    public MatchTypeDto type(MatchDto matchDto) {
        return matchDao
            .findById(matchDto.getId())
            .get()
            .getType()
            .toDto();
    }

    public EventDto event(MatchDto matchDto) {
        return matchDao
            .findById(matchDto.getId())
            .get()
            .getEvent()
            .toDto();
    }

    public UserDto user(MatchDto matchDto) {
        return matchDao
            .findById(matchDto.getId())
            .get()
            .getUser()
            .toDto();
    }

    public TeamDto team(MatchDto matchDto) {
        return matchDao
            .findById(matchDto.getId())
            .get()
            .getTeam()
            .toDto();
    }
}
