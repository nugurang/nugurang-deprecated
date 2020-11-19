package com.nugurang.dao;

import com.nugurang.entity.TeamInvitationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamInvitationDao extends JpaRepository<TeamInvitationEntity, Long> {

}
