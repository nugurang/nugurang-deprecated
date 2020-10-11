package com.nugurang.dao;

import com.nugurang.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamDao extends JpaRepository<TeamEntity, Long> {

}
