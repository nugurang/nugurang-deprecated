package com.nugurang.dao;

import com.nugurang.entity.ArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao extends JpaRepository<ArticleEntity, Long> {

    Long countByThreadId(Long thread);

    Page<ArticleEntity> findAllByThreadIdOrderByCreatedAtAsc(Long thread, Pageable pageable);

    Page<ArticleEntity> findAllByUserId(Long user, Pageable pageable);
}
