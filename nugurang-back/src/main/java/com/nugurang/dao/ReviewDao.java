package com.nugurang.dao;

import com.nugurang.entity.ReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewDao extends JpaRepository<ReviewEntity, Long> {
}
