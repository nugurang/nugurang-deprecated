package com.nugurang.dao;

import com.nugurang.entity.XrefTaskPositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XrefTaskPositionDao extends JpaRepository<XrefTaskPositionEntity, Long> {

}
