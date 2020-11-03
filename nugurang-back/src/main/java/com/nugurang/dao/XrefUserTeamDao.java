package com.nugurang.dao;

import com.nugurang.entity.XrefUserTeamEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XrefUserTeamDao extends JpaRepository<XrefUserTeamEntity, Long> {

    Optional<XrefUserTeamEntity> findByUserIdAndTeamId(Long user, Long team);
}
