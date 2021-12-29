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
public class DbInitConfig {
    private final InvitationStatusDao invitationStatusDao;
    private final MatchTypeDao matchTypeDao;
    private final NotificationTypeDao notificationTypeDao;
    private final ProgressDao progressDao;
    private final RoleDao roleDao;
    private final VoteTypeDao voteTypeDao;

    @PostConstruct
    public void init() {
        for (InvitationStatusName invitationStatusName : InvitationStatusName.values()) {
            invitationStatusDao.save(
                InvitationStatusEntity.builder().name(invitationStatusName.name()).build()
            );
        }

        for (String roleName : List.of(RoleName.OWNER.name(), RoleName.MEMBER.name()))
            roleDao.save(RoleEntity.builder().name(roleName).build());

        for (VoteTypeName voteTypeName : VoteTypeName.values())
            voteTypeDao.save(VoteTypeEntity.builder().name(voteTypeName.name()).build());

        for (ProgressName progressName : ProgressName.values())
            progressDao.save(ProgressEntity.builder().name(progressName.name()).build());

        for (MatchTypeName matchTypeName : MatchTypeName.values())
            matchTypeDao.save(MatchTypeEntity.builder().name(matchTypeName.name()).build());

        for (NotificationTypeName notificationTypeName : NotificationTypeName.values()) {
            notificationTypeDao.save(
                NotificationTypeEntity
                .builder()
                .name(notificationTypeName.name())
                .build()
            );
        }
    }
}
