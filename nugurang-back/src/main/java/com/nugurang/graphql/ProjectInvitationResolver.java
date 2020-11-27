package com.nugurang.graphql;

import com.nugurang.dao.ProjectInvitationDao;
import com.nugurang.dto.InvitationStatusDto;
import com.nugurang.dto.ProjectDto;
import com.nugurang.dto.ProjectInvitationDto;
import com.nugurang.dto.UserDto;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProjectInvitationResolver implements GraphQLResolver<ProjectInvitationDto> {
    private final ProjectInvitationDao projectInvitationDao;

    public ProjectDto project(ProjectInvitationDto projectInvitationDto) {
        return projectInvitationDao
            .findById(projectInvitationDto.getId())
            .get()
            .getProject()
            .toDto();
    }

    public InvitationStatusDto status(ProjectInvitationDto projectInvitationDto) {
        return projectInvitationDao
            .findById(projectInvitationDto.getId())
            .get()
            .getStatus()
            .toDto();
    }

    public UserDto fromUser(ProjectInvitationDto projectInvitationDto) {
        return projectInvitationDao
            .findById(projectInvitationDto.getId())
            .get()
            .getFromUser()
            .toDto();
    }

    public UserDto toUser(ProjectInvitationDto projectInvitationDto) {
        return projectInvitationDao
            .findById(projectInvitationDto.getId())
            .get()
            .getToUser()
            .toDto();
    }
}
