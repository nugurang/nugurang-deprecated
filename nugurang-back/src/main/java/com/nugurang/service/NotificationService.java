package com.nugurang.service;

import com.nugurang.constant.NotificationTypeName;
import com.nugurang.dao.NotificationDao;
import com.nugurang.dao.NotificationTypeDao;
import com.nugurang.entity.NotificationEntity;
import com.nugurang.entity.ProjectEntity;
import com.nugurang.entity.TeamEntity;
import com.nugurang.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationDao notificationDao;
    private final NotificationTypeDao notificationTypeDao;

    NotificationEntity createProjectInvitationNotification(
        ProjectEntity projectEntity, UserEntity userEntity
    ) {
        return notificationDao.save(
            NotificationEntity
            .builder()
            .isRead(false)
            .data(new String[]{projectEntity.getName()})
            .notificationType(
                notificationTypeDao
                .findByName(NotificationTypeName.PROJECT_INVITATION.name())
                .get()
            )
            .user(userEntity)
            .build()
        );
    }

    NotificationEntity createTeamInvitationNotification(
        TeamEntity teamEntity, UserEntity userEntity
    ) {
        return notificationDao.save(
            NotificationEntity
            .builder()
            .isRead(false)
            .data(new String[]{teamEntity.getName()})
            .notificationType(
                notificationTypeDao
                .findByName(NotificationTypeName.TEAM_INVITATION.name())
                .get()
            )
            .user(userEntity)
            .build()
        );
    }
}
