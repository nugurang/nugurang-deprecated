package com.nugurang.repository;

import com.nugurang.entity.XrefUserPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XrefUserPositionRepository extends JpaRepository<XrefUserPosition, Long> {

}
