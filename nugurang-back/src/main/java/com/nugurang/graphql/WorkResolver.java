package com.nugurang.graphql;

import com.nugurang.dao.WorkDao;
import com.nugurang.dto.ProjectDto;
import com.nugurang.dto.WorkDto;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WorkResolver implements GraphQLResolver<WorkDto> {
    private final WorkDao workDao;

    public ProjectDto project(WorkDto workDto) {
        return workDao
            .findById(workDto.getId())
            .map((workEntity) -> workEntity.getProject())
            .map((projectEntity) -> projectEntity.toDto())
            .get();
    }
}
