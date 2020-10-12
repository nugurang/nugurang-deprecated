package com.nugurang.graphql;

import com.nugurang.dao.EventDao;
import com.nugurang.dao.TeamDao;
import com.nugurang.dao.WorkDao;
import com.nugurang.dto.EventDto;
import com.nugurang.dto.ProjectDto;
import com.nugurang.dto.TeamDto;
import com.nugurang.dto.WorkDto;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProjectResolver implements GraphQLResolver<ProjectDto> {
    private final TeamDao teamDao;
    private final EventDao eventDao;
    private final WorkDao workDao;

    public TeamDto team(ProjectDto project) {
        return null;
    }

    public EventDto event(ProjectDto project) {
        return null;
    }

    public List<WorkDto> works(ProjectDto project, int page, int pageSize) {
        return null;
    }
}
