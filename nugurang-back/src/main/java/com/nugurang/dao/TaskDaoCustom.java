package com.nugurang.dao;

import com.nugurang.entity.TaskEntity;
import java.util.List;

public interface TaskDaoCustom {

    List<TaskEntity> findAllByUserId(Long user);
}
