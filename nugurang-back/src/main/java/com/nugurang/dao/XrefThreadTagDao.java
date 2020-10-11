package com.nugurang.dao;

import com.nugurang.entity.XrefThreadTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XrefThreadTagDao extends JpaRepository<XrefThreadTagEntity, Long> {

}
