package com.nugurang.repository;

import com.nugurang.entity.XrefUserBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XrefUserBoardRepository extends JpaRepository<XrefUserBoardEntity, Long> {

}
