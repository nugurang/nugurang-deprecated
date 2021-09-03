package com.nugurang.graphql.query;

import com.nugurang.dto.ProjectDto;
import com.nugurang.service.ProjectService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectQuery implements GraphQLQueryResolver {

    private final ProjectService projectService;

    public Optional<ProjectDto> getProject(Long id) {
        return projectService.getProject(id).map((entity) -> entity.toDto());
    }
}
