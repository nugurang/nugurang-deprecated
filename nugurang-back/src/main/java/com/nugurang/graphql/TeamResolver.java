package com.nugurang.graphql;

import com.nugurang.constant.RoleName;
import com.nugurang.dao.ProjectDao;
import com.nugurang.dao.RoleDao;
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
    private final RoleDao roleDao;
    private final ProjectDao projectDao;
    private final UserDao userDao;

    public List<ProjectDto> projects(TeamDto teamDto) {
        return projectDao
            .findAllByTeamId(teamDto.getId())
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    UserDto owner(TeamDto teamDto) {
        return userDao.findFirstByTeamIdAndRoleId(
            teamDto.getId(),
            roleDao.findByName(RoleName.OWNER.name()).get().getId()
        )
        .get()
        .toDto();
    }

    public List<UserDto> getMembers(TeamDto teamDto, Integer page, Integer pageSize) {
        return userDao
            .findAllByTeamIdAndRoleId(
                teamDto.getId(),
                roleDao.findByName(RoleName.MEMBER.name()).get().getId(),
                PageRequest.of(page, pageSize)
            )
            .getContent()
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }
}
