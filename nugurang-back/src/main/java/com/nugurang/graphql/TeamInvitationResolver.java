package com.nugurang.graphql;

import com.nugurang.dao.TeamInvitationDao;
import com.nugurang.dto.TeamDto;
import com.nugurang.dto.TeamInvitationDto;
import com.nugurang.dto.UserDto;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TeamInvitationResolver implements GraphQLResolver<TeamInvitationDto> {

    private final TeamInvitationDao teamInvitationDao;

    public TeamDto team(TeamInvitationDto teamInvitationDto) {
        return teamInvitationDao
            .findById(teamInvitationDto.getId())
            .get()
            .getTeam()
            .toDto();
    }

    public UserDto user(TeamInvitationDto teamInvitationDto) {
        return teamInvitationDao
            .findById(teamInvitationDto.getId())
            .get()
            .getUser()
            .toDto();
    }
}
