package com.nugurang.dao;

import com.nugurang.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageDao extends JpaRepository<ImageEntity, Long> {

}
