package com.nugurang.repository;

import com.nugurang.entity.XrefUserBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XrefUserBoardRepository extends JpaRepository<XrefUserBoard, Long> {

}
