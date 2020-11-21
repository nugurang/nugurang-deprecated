package com.nugurang.dao;

import com.nugurang.entity.NotificationDataEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationDataDao extends JpaRepository<NotificationDataEntity, Long> {

    List<NotificationDataEntity> findAllByNotificationIdOrderByIdAsc(Long notification);
}
