package com.nugurang.graphql;

import com.nugurang.dao.ProjectInvitationDao;
import com.nugurang.dto.ProjectDto;
import com.nugurang.dto.ProjectInvitationDto;
import com.nugurang.dto.UserDto;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProjectInvitationResolver implements GraphQLResolver<ProjectInvitationDto> {
    ProjectInvitationDao projectInvitationDao;

    public ProjectDto project(ProjectInvitationDto projectInvitationDto) {
        return projectInvitationDao
            .findById(projectInvitationDto.getId())
            .get()
            .getProject()
            .toDto();
    }

    public UserDto user(ProjectInvitationDto projectInvitationDto) {
        return projectInvitationDao
            .findById(projectInvitationDto.getId())
            .get()
            .getUser()
            .toDto();
    }
}
