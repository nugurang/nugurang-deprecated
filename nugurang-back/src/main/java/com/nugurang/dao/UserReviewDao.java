package com.nugurang.dao;

import com.nugurang.entity.UserReviewEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReviewDao extends JpaRepository<UserReviewEntity, Long> {

    List<UserReviewEntity> findAllByToUserId(Long toUser);

    List<UserReviewEntity> findAllByToUserIdIn(List<Long> toUsers);

    List<UserReviewEntity> findAllByUserEvaluationId(Long userEvaluation);

    void deleteAllByIdIn(List<Long> ids);

    void deleteAllByUserEvaluationIdAndFromUserId(Long userEvaluation, Long fromUser);

    void deleteByUserEvaluationIdAndFromUserIdAndToUserId(
        Long userEvaluation,
        Long fromUser,
        Long toUser
    );
}
