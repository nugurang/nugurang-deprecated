package com.nugurang.graphql;

import com.nugurang.dao.ProjectDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dto.ProjectDto;
import com.nugurang.dto.TeamDto;
import com.nugurang.dto.UserDto;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TeamResolver implements GraphQLResolver<TeamDto> {
    private final UserDao userDao;
    private final ProjectDao projectDao;

    public List<ProjectDto> projects(TeamDto teamDto) {
        return projectDao
            .findAllByTeamId(teamDto.getId())
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    public List<UserDto> getUsers(TeamDto teamDto, Integer page, Integer pageSize) {
        return userDao
            .findAllByTeamId(teamDto.getId(), PageRequest.of(page, pageSize))
            .getContent()
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }
}
