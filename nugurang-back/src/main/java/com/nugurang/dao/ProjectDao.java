package com.nugurang.dao;

import com.nugurang.entity.ProjectEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDao extends JpaRepository<ProjectEntity, Long> {

    List<ProjectEntity> findAllByTeamId(Long team);
}
