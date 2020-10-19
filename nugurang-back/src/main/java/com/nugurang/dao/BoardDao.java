package com.nugurang.dao;

import com.nugurang.entity.BoardEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardDao extends JpaRepository<BoardEntity, Long> {
    Optional<BoardEntity> findByName(String name);
}
