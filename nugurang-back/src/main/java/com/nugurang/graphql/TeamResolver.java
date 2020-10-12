package com.nugurang.graphql;

import com.nugurang.dao.ProjectDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dto.ProjectDto;
import com.nugurang.dto.TeamDto;
import com.nugurang.dto.UserDto;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TeamResolver implements GraphQLResolver<TeamDto> {

    private final UserDao userDao;
    private final ProjectDao projectDao;

    public List<UserDto> users(TeamDto teamDto) {
        return null;
    }

    public List<ProjectDto> projects(TeamDto teamDto) {
        return null;
    }
}
