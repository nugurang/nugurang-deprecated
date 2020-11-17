package com.nugurang.dao;

import com.nugurang.entity.TaskHonorEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskHonorDao extends JpaRepository<TaskHonorEntity, Long> {

    List<TaskHonorEntity> findAllByTaskId(Long task);
}
