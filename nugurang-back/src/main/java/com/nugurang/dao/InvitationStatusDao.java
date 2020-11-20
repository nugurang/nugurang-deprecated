package com.nugurang.dao;

import com.nugurang.entity.InvitationStatusEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitationStatusDao extends JpaRepository<InvitationStatusEntity, Long> {

    Optional<InvitationStatusEntity> findByName(String name);
}
