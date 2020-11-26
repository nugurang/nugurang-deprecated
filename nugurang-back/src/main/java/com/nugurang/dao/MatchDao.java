package com.nugurang.dao;

import com.nugurang.entity.MatchEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchDao extends JpaRepository<MatchEntity, Long> {

    List<MatchEntity> findAllByUserId(Long user);
}
