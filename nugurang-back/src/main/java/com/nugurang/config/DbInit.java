package com.nugurang.config;

import com.nugurang.constant.ProgressName;
import com.nugurang.constant.RoleName;
import com.nugurang.constant.VoteTypeName;
import com.nugurang.dao.ArticleDao;
import com.nugurang.dao.BoardDao;
import com.nugurang.dao.ProgressDao;
import com.nugurang.dao.RoleDao;
import com.nugurang.dao.ThreadDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dao.VoteTypeDao;
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
    private final ArticleDao articleDao;
    private final BoardDao boardDao;
    private final ProgressDao progressDao;
    private final RoleDao roleDao;
    private final ThreadDao threadDao;
    private final UserDao userDao;
    private final VoteTypeDao voteTypeDao;

    @PostConstruct
    public void init() {
        for (String roleName : List.of(RoleName.OWNER.name(), RoleName.MEMBER.name()))
            roleDao.save(RoleEntity.builder().name(roleName).build());
        for (String voteTypeName : List.of(VoteTypeName.UP.name(), VoteTypeName.DOWN.name(), VoteTypeName.STAR.name()))
            voteTypeDao.save(VoteTypeEntity.builder().name(voteTypeName).build());
        for (String progressName : List.of(ProgressName.TODO.name(), ProgressName.DOING.name(), ProgressName.DONE.name()))
            progressDao.save(ProgressEntity.builder().name(progressName).build());
    }
}
