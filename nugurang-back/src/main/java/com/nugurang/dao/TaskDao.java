package com.nugurang.dao;

import com.nugurang.entity.TaskEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao extends JpaRepository<TaskEntity, Long>, TaskDaoCustom {

    Optional<TaskEntity> findFirstByOrderByOrderDesc();

    List<TaskEntity> findAllByWorkId(Long work);
}
