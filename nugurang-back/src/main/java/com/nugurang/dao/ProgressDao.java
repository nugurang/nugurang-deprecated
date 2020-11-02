package com.nugurang.dao;

import com.nugurang.entity.ProgressEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressDao extends JpaRepository<ProgressEntity, Long> {

    Optional<ProgressEntity> findByName(String name);
}
