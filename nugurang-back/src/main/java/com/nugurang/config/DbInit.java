package com.nugurang.config;

import com.nugurang.constant.InvitationStatusName;
import com.nugurang.constant.MatchTypeName;
import com.nugurang.constant.NotificationTypeName;
import com.nugurang.constant.ProgressName;
import com.nugurang.constant.RoleName;
import com.nugurang.constant.VoteTypeName;
import com.nugurang.dao.InvitationStatusDao;
import com.nugurang.dao.MatchTypeDao;
import com.nugurang.dao.NotificationTypeDao;
import com.nugurang.dao.ProgressDao;
import com.nugurang.dao.RoleDao;
import com.nugurang.dao.VoteTypeDao;
import com.nugurang.entity.InvitationStatusEntity;
import com.nugurang.entity.MatchTypeEntity;
import com.nugurang.entity.NotificationTypeEntity;
import com.nugurang.entity.ProgressEntity;
import com.nugurang.entity.RoleEntity;
import com.nugurang.entity.VoteTypeEntity;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DbInit {
    private final InvitationStatusDao invitationStatusDao;
    private final MatchTypeDao matchTypeDao;
    private final NotificationTypeDao notificationTypeDao;
    private final ProgressDao progressDao;
    private final RoleDao roleDao;
    private final VoteTypeDao voteTypeDao;

    @PostConstruct
    public void init() {
        for (String invitationStatusName : List.of(
                InvitationStatusName.UNACCEPTED.name(),
                InvitationStatusName.DENIED.name(),
                InvitationStatusName.ACCEPTED.name()
            )) {
            invitationStatusDao.save(
                InvitationStatusEntity.builder().name(invitationStatusName).build()
            );
        }

        for (String roleName : List.of(RoleName.OWNER.name(), RoleName.MEMBER.name()))
            roleDao.save(RoleEntity.builder().name(roleName).build());

        for (String voteTypeName : List.of(
                VoteTypeName.VIEW.name(),
                VoteTypeName.UP.name(),
                VoteTypeName.DOWN.name(),
                VoteTypeName.STAR.name()
            )) {
            voteTypeDao.save(VoteTypeEntity.builder().name(voteTypeName).build());
        }

        for (String progressName : List.of(
            ProgressName.TODO.name(),
            ProgressName.DOING.name(),
            ProgressName.DONE.name())
        ) {
            progressDao.save(ProgressEntity.builder().name(progressName).build());
        }

        for (String matchTypeName : List.of(
            MatchTypeName.RANDOM.name(),
            MatchTypeName.HONOR.name(),
            MatchTypeName.PERSONALITY.name())
        ) {
            matchTypeDao.save(MatchTypeEntity.builder().name(matchTypeName).build());
        }

        for (String notificationTypeName : List.of(
                NotificationTypeName.PROJECT_INVITATION.name(),
                NotificationTypeName.TEAM_INVITATION.name(),
                NotificationTypeName.MATCH_SUCCESS.name(),
                NotificationTypeName.MATCH_FAILURE.name()
            )) {
            notificationTypeDao.save(
                NotificationTypeEntity
                .builder()
                .name(notificationTypeName)
                .build()
            );
        }
    }
}
