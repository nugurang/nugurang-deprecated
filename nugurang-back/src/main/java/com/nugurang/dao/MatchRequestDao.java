package com.nugurang.dao;

import com.nugurang.entity.MatchRequestEntity;
import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRequestDao extends JpaRepository<MatchRequestEntity, Long> {

    List<MatchRequestEntity> findAllByEventId(Long event);

    List<MatchRequestEntity> findAllByUserId(Long user);

    List<MatchRequestEntity> findAllByExpiredAtLessThan(OffsetDateTime at);
}
