package com.nugurang.graphql;

import com.nugurang.dao.ProjectDao;
import com.nugurang.dto.ProjectDto;
import com.nugurang.dto.WorkDto;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WorkResolver implements GraphQLResolver<WorkDto> {
    private final ProjectDao projectDao;

    public ProjectDto project(WorkDto workDto) {
        return null;
        //return projectDao.findByWork_Id(workDto.getId());
    }

}
