package com.nugurang.dao;

import com.nugurang.entity.UserEvaluationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEvaluationDao extends JpaRepository<UserEvaluationEntity, Long> {
}
