package com.nugurang.service;

import com.nugurang.constant.NotificationTypeName;
import com.nugurang.dao.NotificationDao;
import com.nugurang.dao.NotificationDataDao;
import com.nugurang.dao.NotificationTypeDao;
import com.nugurang.entity.EventEntity;
import com.nugurang.entity.MatchTypeEntity;
import com.nugurang.entity.NotificationDataEntity;
import com.nugurang.entity.NotificationEntity;
import com.nugurang.entity.ProjectInvitationEntity;
import com.nugurang.entity.TeamEntity;
import com.nugurang.entity.TeamInvitationEntity;
import com.nugurang.entity.UserEntity;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationDao notificationDao;
    private final NotificationDataDao notificationDataDao;
    private final NotificationTypeDao notificationTypeDao;

    @Transactional
    private NotificationEntity createNotification(
        UserEntity userEntity,
        NotificationTypeName type,
        List<String> data
    ) {
        val notificationEntity = notificationDao.save(
            NotificationEntity
            .builder()
            .isRead(false)
            .notificationType(
                notificationTypeDao
                .findByName(type.name())
                .get()
            )
            .user(userEntity)
            .build()
        );

        notificationDataDao.saveAll(
            data
            .stream()
            .map((datum) ->
                NotificationDataEntity
                .builder()
                .value(datum)
                .notification(notificationEntity)
               .build()
            )
            .collect(Collectors.toList())
        );

        return notificationEntity;
    }

    public NotificationEntity createProjectInvitationNotification(
        UserEntity userEntity,
        ProjectInvitationEntity projectInvitationEntity
    ) {
        return createNotification(
            userEntity,
            NotificationTypeName.PROJECT_INVITATION,
            List.of(projectInvitationEntity.getId().toString())
        );
    }

    public NotificationEntity createTeamInvitationNotification(
        UserEntity userEntity,
        TeamInvitationEntity teamInvitationEntity
    ) {
        return createNotification(
            userEntity,
            NotificationTypeName.TEAM_INVITATION,
            List.of(teamInvitationEntity.getId().toString())
        );
    }

    public NotificationEntity createMatchSuccessNotification(
        UserEntity userEntity,
        MatchTypeEntity matchTypeEntity,
        EventEntity eventEntity,
        TeamEntity teamEntity) {
        return createNotification(
            userEntity,
            NotificationTypeName.MATCH_SUCCESS,
            List.of(
                matchTypeEntity.getId().toString(),
                eventEntity.getId().toString(),
                teamEntity.getId().toString()
            )
        );
    }

    public NotificationEntity createMatchFailureNotification(
        UserEntity userEntity,
        EventEntity eventEntity,
        MatchTypeEntity matchTypeEntity) {
        return createNotification(
            userEntity,
            NotificationTypeName.MATCH_FAILURE,
            List.of(
                matchTypeEntity.getId().toString(),
                eventEntity.getId().toString()
            )
        );
    }
}
