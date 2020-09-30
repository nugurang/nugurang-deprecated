package com.nugurang.repository;

import com.nugurang.entity.XrefArticleImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XrefArticleImageRepository extends JpaRepository<XrefArticleImage, Long> {

}
