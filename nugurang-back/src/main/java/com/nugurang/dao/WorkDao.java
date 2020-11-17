package com.nugurang.dao;

import com.nugurang.entity.WorkEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkDao extends JpaRepository<WorkEntity, Long> {

    Optional<WorkEntity> findFirstByOrderByOrderDesc();

    List<WorkEntity> findAllByProjectId(Long project);
}
