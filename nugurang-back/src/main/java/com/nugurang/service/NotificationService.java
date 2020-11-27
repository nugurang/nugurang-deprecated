package com.nugurang.service;

import com.nugurang.constant.NotificationTypeName;
import com.nugurang.dao.NotificationDao;
import com.nugurang.dao.NotificationDataDao;
import com.nugurang.dao.NotificationTypeDao;
import com.nugurang.entity.NotificationDataEntity;
import com.nugurang.entity.NotificationEntity;
import com.nugurang.entity.ProjectInvitationEntity;
import com.nugurang.entity.TeamInvitationEntity;
import com.nugurang.entity.UserEntity;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationDao notificationDao;
    private final NotificationDataDao notificationDataDao;
    private final NotificationTypeDao notificationTypeDao;

    private List<NotificationDataEntity> createNotificationData(
        NotificationEntity notificationEntity,
        List<String> data
    ) {
        return data
        .stream()
        .map((datum) ->
            notificationDataDao.save(
                NotificationDataEntity
                .builder()
                .value(datum)
                .notification(notificationEntity)
               .build()
            )
        )
        .collect(Collectors.toList());
    }

    @Transactional
    public NotificationEntity createProjectInvitationNotification(
        ProjectInvitationEntity projectInvitationEntity, UserEntity userEntity
    ) {
        NotificationEntity notificationEntity = notificationDao.save(
            NotificationEntity
            .builder()
            .isRead(false)
            .notificationType(
                notificationTypeDao
                .findByName(NotificationTypeName.PROJECT_INVITATION.name())
                .get()
            )
            .user(userEntity)
            .build()
        );

        createNotificationData(
            notificationEntity,
            List.of(projectInvitationEntity.getId().toString())
        );

        return notificationEntity;
    }

    @Transactional
    public NotificationEntity createTeamInvitationNotification(
        TeamInvitationEntity teamInvitationEntity, UserEntity userEntity
    ) {
        NotificationEntity notificationEntity = notificationDao.save(
            NotificationEntity
            .builder()
            .isRead(false)
            .notificationType(
                notificationTypeDao
                .findByName(NotificationTypeName.TEAM_INVITATION.name())
                .get()
            )
            .user(userEntity)
            .build()
        );

        createNotificationData(
            notificationEntity,
            List.of(teamInvitationEntity.getId().toString())
        );
        return notificationEntity;
    }
}
