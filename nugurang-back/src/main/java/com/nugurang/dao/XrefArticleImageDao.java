package com.nugurang.dao;

import com.nugurang.entity.XrefArticleImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XrefArticleImageDao extends JpaRepository<XrefArticleImageEntity, Long> {

}
