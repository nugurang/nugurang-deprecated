package com.nugurang.dao;

import com.nugurang.entity.NotificationTypeEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationTypeDao extends JpaRepository<NotificationTypeEntity, Long> {

    Optional<NotificationTypeEntity> findByName(String name);
}
