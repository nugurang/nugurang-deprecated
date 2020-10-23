package com.nugurang.graphql;

import com.nugurang.dao.PositionDao;
import com.nugurang.dao.ProgressDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dao.WorkDao;
import com.nugurang.dto.ProgressDto;
import com.nugurang.dto.TaskDto;
import com.nugurang.dto.TaskHonorDto;
import com.nugurang.dto.UserDto;
import com.nugurang.dto.WorkDto;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TaskResolver implements GraphQLResolver<TaskDto> {

    private final WorkDao workerDao;
    private final ProgressDao progressDao;
    private final PositionDao positionDao;
    private final UserDao userDao;

    public WorkDto work(TaskDto taskDto) {
        return null;
    }

    public ProgressDto progress(TaskDto taskDto) {
        return null;
    }

    public List<TaskHonorDto> honors(TaskDto taskDto) {
        return null;
    }

    public List<UserDto> users(TaskDto taskDto) {
        return null;
    }

}
