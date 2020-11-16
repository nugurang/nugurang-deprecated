package com.nugurang.dao;

import com.nugurang.entity.ProjectEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDao extends JpaRepository<ProjectEntity, Long>, ProjectDaoCustom {

    Optional<ProjectEntity> findByUserEvaluationId(Long userEvaluation);

    List<ProjectEntity> findAllByTeamId(Long team);
}
