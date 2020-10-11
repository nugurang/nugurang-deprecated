package com.nugurang.dao;

import com.nugurang.entity.XrefUserBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XrefUserBoardDao extends JpaRepository<XrefUserBoardEntity, Long> {

}
