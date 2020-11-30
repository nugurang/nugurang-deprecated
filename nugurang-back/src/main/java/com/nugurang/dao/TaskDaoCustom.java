package com.nugurang.dao;

import com.nugurang.entity.TaskEntity;
import java.util.List;

public interface TaskDaoCustom {

    List<TaskEntity> findAllByProjectId(Long project);

    List<TaskEntity> findAllByUserId(Long user);
}
