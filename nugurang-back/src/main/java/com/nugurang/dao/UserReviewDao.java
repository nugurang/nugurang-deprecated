package com.nugurang.dao;

import com.nugurang.entity.UserReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReviewDao extends JpaRepository<UserReviewEntity, Long> {
}
