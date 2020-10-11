package com.nugurang.dao;

import com.nugurang.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagDao extends JpaRepository<TagEntity, Long> {

}
