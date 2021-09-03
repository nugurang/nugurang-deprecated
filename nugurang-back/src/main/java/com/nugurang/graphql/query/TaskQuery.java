package com.nugurang.graphql.query;

import com.nugurang.dto.TaskDto;
import com.nugurang.service.TaskService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskQuery implements GraphQLQueryResolver {

    private final TaskService taskService;

    public Optional<TaskDto> getTask(Long id) {
        return taskService.getTask(id).map((entity) -> entity.toDto());
    }
}
