package com.nugurang.repository;

import com.nugurang.entity.XrefTaskPositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XrefTaskPositionRepository extends JpaRepository<XrefTaskPositionEntity, Long> {

}
