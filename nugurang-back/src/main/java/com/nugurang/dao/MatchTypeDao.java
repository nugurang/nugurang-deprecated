package com.nugurang.dao;

import com.nugurang.entity.MatchTypeEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchTypeDao extends JpaRepository<MatchTypeEntity, Long> {

    Optional<MatchTypeEntity> findByName(String name);
}
