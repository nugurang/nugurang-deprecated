package com.nugurang.dao;

import com.nugurang.entity.XrefUserProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XrefUserProjectDao extends JpaRepository<XrefUserProjectEntity, Long> {

}
