package com.nugurang.dao;

import com.nugurang.entity.NotificationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationDao extends JpaRepository<NotificationEntity, Long> {

    Page<NotificationEntity> findAllByUserId(Long user, Pageable pageable);
}
