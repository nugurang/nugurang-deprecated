package com.nugurang.service;

import com.nugurang.constant.ProgressName;
import com.nugurang.dao.PositionDao;
import com.nugurang.dao.ProgressDao;
import com.nugurang.dao.TaskDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dao.WorkDao;
import com.nugurang.dao.XrefTaskPositionDao;
import com.nugurang.dao.XrefUserTaskDao;
import com.nugurang.dto.TaskInputDto;
import com.nugurang.entity.TaskEntity;
import com.nugurang.entity.XrefTaskPositionEntity;
import com.nugurang.entity.XrefUserTaskEntity;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final PositionDao positionDao;
    private final ProgressDao progressDao;
    private final TaskDao taskDao;
    private final UserDao userDao;
    private final WorkDao workDao;
    private final XrefTaskPositionDao xrefTaskPositionDao;
    private final XrefUserTaskDao xrefUserTaskDao;

    @Transactional
    public TaskEntity createTask(TaskInputDto taskInputDto, Long work) {
        TaskEntity taskEntity = taskDao.save(
            TaskEntity
            .builder()
            .name(taskInputDto.getName())
            .order(
                taskInputDto
                .getOrder()
                .orElseGet(() ->
                    taskDao
                    .findFirstByOrderByOrderDesc()
                    .map((prevTaskEntity) -> prevTaskEntity.getOrder() + 1)
                    .orElse(0)
                )
            )
            .difficulty(taskInputDto.getDifficulty().orElse(1))
            .work(workDao.findById(work).get())
            .progress(
                taskInputDto
                .getProgress()
                .map((progressId) -> progressDao.findById(progressId).get())
                .orElseGet(() -> progressDao.findByName(ProgressName.TODO.name()).get())
            )
            .build()
        );

        xrefUserTaskDao.saveAll(
            taskInputDto
            .getUsers()
            .stream()
            .map((userId) -> userDao.findById(userId).get())
            .map((userEntity) ->
                XrefUserTaskEntity
                .builder()
                .user(userEntity)
                .task(taskEntity)
                .build()
            )
            .collect(Collectors.toList())
        );

        xrefTaskPositionDao.saveAll(
            taskInputDto
            .getPositions()
            .stream()
            .map((positionId) ->
                positionDao.findById(positionId).get()
            )
            .map((positionEntity) ->
                XrefTaskPositionEntity
                .builder()
                .task(taskEntity)
                .position(positionEntity)
                .build()
            )
            .collect(Collectors.toList())
        );

        return taskEntity;
    }

    public TaskEntity updateTask(TaskInputDto taskInputDto, Long id) {
        TaskEntity taskEntity = taskDao.findById(id).get();

        taskEntity.setName(taskInputDto.getName());

        if (taskInputDto.getOrder().isPresent())
            taskEntity.setOrder(taskInputDto.getOrder().get());

        if (taskInputDto.getDifficulty().isPresent())
            taskEntity.setDifficulty(taskInputDto.getDifficulty().get());

        if (taskInputDto.getProgress().isPresent()) {
            taskEntity.setProgress(
                progressDao.findById(taskInputDto.getProgress().get()).get()
            );
        }
        return taskDao.save(taskEntity);
    }

    public Long deleteTask(Long taskId) {
        return taskId;
    }
}
