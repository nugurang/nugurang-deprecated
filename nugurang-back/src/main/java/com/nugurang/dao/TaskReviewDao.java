package com.nugurang.dao;

import com.nugurang.entity.TaskReviewEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TaskReviewDao extends JpaRepository<TaskReviewEntity, Long> {

    List<TaskReviewEntity> findAllByTaskId(Long task);

    @Transactional
    void deleteByTaskIdAndUserId(Long task, Long user);
}
