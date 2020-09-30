package com.nugurang.repository;

import com.nugurang.entity.XrefTaskPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XrefTaskPositionRepository extends JpaRepository<XrefTaskPosition, Long> {

}
