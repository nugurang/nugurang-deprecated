package com.nugurang.dao;

import com.nugurang.entity.ThreadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreadDao extends JpaRepository<ThreadEntity, Long> {
}
