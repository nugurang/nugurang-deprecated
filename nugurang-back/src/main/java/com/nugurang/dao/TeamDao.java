package com.nugurang.dao;

import com.nugurang.entity.TeamEntity;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamDao extends JpaRepository<TeamEntity, Long>, TeamDaoCustom {

    Optional<TeamEntity> findByName(String name);

    Page<TeamEntity> findAllByNameContainingIgnoreCase(String name, Pageable pageable);
}
