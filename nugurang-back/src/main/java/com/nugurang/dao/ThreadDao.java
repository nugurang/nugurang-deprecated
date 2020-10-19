package com.nugurang.dao;

import com.nugurang.entity.ThreadEntity;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreadDao extends JpaRepository<ThreadEntity, Long> {

    Page<ThreadEntity> findAllByBoardIdInOrderByCreatedAtDesc(List<Long> boards, Pageable pageable);

    Page<ThreadEntity> findAllByBoardIdOrderByCreatedAtDesc(Long board, Pageable pageable);

}
