package com.nugurang.dao;

import com.nugurang.entity.ProjectInvitationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectInvitationDao extends JpaRepository<ProjectInvitationEntity, Long> {

}
