package com.nugurang.graphql;

import com.nugurang.dao.PositionDao;
import com.nugurang.dao.ProgressDao;
import com.nugurang.dao.TaskDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dao.WorkDao;
import com.nugurang.dto.PositionDto;
import com.nugurang.dto.ProgressDto;
import com.nugurang.dto.TaskDto;
import com.nugurang.dto.UserDto;
import com.nugurang.dto.WorkDto;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TaskResolver implements GraphQLResolver<TaskDto> {

    private final WorkDao workerDao;
    private final ProgressDao progressDao;
    private final PositionDao positionDao;
    private final TaskDao taskDao;
    private final UserDao userDao;

    public WorkDto work(TaskDto taskDto) {
        return taskDao
            .findById(taskDto.getId())
            .get()
            .getWork()
            .toDto();
    }

    public ProgressDto progress(TaskDto taskDto) {
        return taskDao
            .findById(taskDto.getId())
            .get()
            .getProgress()
            .toDto();
    }

    public List<PositionDto> positions(TaskDto taskDto) {
        return positionDao
            .findAllByTaskId(taskDto.getId())
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    public List<UserDto> users(TaskDto taskDto) {
        return userDao
            .findAllByTaskId(taskDto.getId())
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }
}
