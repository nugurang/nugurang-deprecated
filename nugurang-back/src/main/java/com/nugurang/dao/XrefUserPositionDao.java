package com.nugurang.repository;

import com.nugurang.entity.XrefUserPositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XrefUserPositionRepository extends JpaRepository<XrefUserPositionEntity, Long> {

}
