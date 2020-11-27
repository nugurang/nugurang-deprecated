package com.nugurang.dao;

import com.nugurang.entity.XrefTaskPositionEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XrefTaskPositionDao extends JpaRepository<XrefTaskPositionEntity, Long> {

    List<XrefTaskPositionEntity> findAllByTaskId(Long task);
}
