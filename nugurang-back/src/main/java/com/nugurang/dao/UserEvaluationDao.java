package com.nugurang.dao;

import com.nugurang.entity.UserEvaluationEntity;
import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEvaluationDao extends JpaRepository<UserEvaluationEntity, Long> {

    List<UserEvaluationEntity> findAllByExpiredAtLessThanEqual(OffsetDateTime at);

    void deleteAllByIdIn(List<Long> ids);
}
