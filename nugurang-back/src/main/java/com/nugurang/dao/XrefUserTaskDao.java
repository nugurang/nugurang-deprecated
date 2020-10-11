package com.nugurang.repository;

import com.nugurang.entity.XrefUserTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XrefUserTaskRepository extends JpaRepository<XrefUserTaskEntity, Long> {

}
