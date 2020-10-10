package com.nugurang.repository;

import com.nugurang.entity.XrefArticleImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XrefArticleImageRepository extends JpaRepository<XrefArticleImageEntity, Long> {

}
