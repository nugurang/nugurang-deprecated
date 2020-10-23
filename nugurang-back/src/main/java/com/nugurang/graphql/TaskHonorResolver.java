package com.nugurang.graphql;

import com.nugurang.dao.TaskHonorDao;
import com.nugurang.dto.PositionDto;
import com.nugurang.dto.TaskDto;
import com.nugurang.dto.TaskHonorDto;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TaskHonorResolver implements GraphQLResolver<TaskHonorDto> {
    private final TaskHonorDao taskHonorDao;

    public TaskDto task(TaskHonorDto taskHonorDto) {
        return null;
    }

    public PositionDto position(TaskHonorDto taskHonorDto) {
        return null;
    }
}
