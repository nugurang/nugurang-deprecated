package com.nugurang.graphql.mutation;

import com.nugurang.dto.TaskDto;
import com.nugurang.dto.TaskInputDto;
import com.nugurang.service.TaskService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskMutation implements GraphQLMutationResolver {

    private final TaskService taskService;

    public TaskDto createTask(TaskInputDto taskInputDto, Long workId) {
        return taskService.createTask(taskInputDto, workId).toDto();
    }

    public TaskDto updateTask(TaskInputDto taskInputDto, Long taskId) {
        return taskService.updateTask(taskInputDto, taskId).toDto();
    }

    public Long deleteTask(Long taskId) {
        taskService.deleteTask(taskId);
        return taskId;
    }
}
