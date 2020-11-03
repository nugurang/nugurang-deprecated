package com.nugurang.dao;

import com.nugurang.entity.TaskEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao extends JpaRepository<TaskEntity, Long> {

    List<TaskEntity> findAllByWorkId(Long work);
}
