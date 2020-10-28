package com.nugurang.dao;

import com.nugurang.entity.WorkEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkDao extends JpaRepository<WorkEntity, Long> {

    Page<WorkEntity> findByProjectId(Long project, Pageable pageable);
}
