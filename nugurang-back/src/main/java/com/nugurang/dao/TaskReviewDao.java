package com.nugurang.dao;

import com.nugurang.entity.TaskReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskReviewDao extends JpaRepository<TaskReviewEntity, Long> {

    void deleteByTaskIdAndUserId(Long task, Long user);
}
