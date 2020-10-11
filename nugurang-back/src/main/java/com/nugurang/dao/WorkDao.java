package com.nugurang.dao;

import com.nugurang.entity.WorkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkDao extends JpaRepository<WorkEntity, Long> {

}
