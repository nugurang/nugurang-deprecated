package com.nugurang.graphql.resolver;

import com.nugurang.dao.TeamInvitationDao;
import com.nugurang.dto.InvitationStatusDto;
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

    public InvitationStatusDto status(TeamInvitationDto teamInvitationDto) {
        return teamInvitationDao
            .findById(teamInvitationDto.getId())
            .get()
            .getStatus()
            .toDto();
    }

    public UserDto fromUser(TeamInvitationDto teamInvitationDto) {
        return teamInvitationDao
            .findById(teamInvitationDto.getId())
            .get()
            .getFromUser()
            .toDto();
    }

    public UserDto toUser(TeamInvitationDto teamInvitationDto) {
        return teamInvitationDao
            .findById(teamInvitationDto.getId())
            .get()
            .getToUser()
            .toDto();
    }
}
