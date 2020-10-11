package com.nugurang.dao;

import com.nugurang.entity.XrefUserPositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XrefUserPositionDao extends JpaRepository<XrefUserPositionEntity, Long> {

}
