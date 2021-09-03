package com.nugurang.graphql.query;

import com.nugurang.dto.TeamDto;
import com.nugurang.service.TeamService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamQuery implements GraphQLQueryResolver {

    private final TeamService teamService;

    public Optional<TeamDto> getTeam(Long id) {
        return teamService.getTeam(id).map((entity) -> entity.toDto());
    }

    public Optional<TeamDto> getTeamByName(String name) {
        return teamService.getTeam(name).map((entity) -> entity.toDto());
    }

    public List<TeamDto> getTeamsByName(String name, Integer page, Integer pageSize) {
        return teamService
            .getTeams(name, PageRequest.of(page, pageSize))
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }
}
