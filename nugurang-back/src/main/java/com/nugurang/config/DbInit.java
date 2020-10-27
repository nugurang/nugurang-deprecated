package com.nugurang.config;

import com.nugurang.dao.ArticleDao;
import com.nugurang.dao.BoardDao;
import com.nugurang.dao.RoleDao;
import com.nugurang.dao.ThreadDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dao.VoteTypeDao;
import com.nugurang.entity.ArticleEntity;
import com.nugurang.entity.BoardEntity;
import com.nugurang.entity.RoleEntity;
import com.nugurang.entity.VoteTypeEntity;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DbInit {
    private final ArticleDao articleDao;
    private final BoardDao boardDao;
    private final RoleDao roleDao;
    private final ThreadDao threadDao;
    private final UserDao userDao;
    private final VoteTypeDao voteTypeDao;

    @PostConstruct
    public void init() {
        for (String roleName : List.of("ADMIN", "MEMBER")) {
            RoleEntity roleEntity = RoleEntity.builder().name(roleName).build();
            roleDao.save(roleEntity);
        }
        for (String voteTypeName : List.of("UP", "DOWN")) {
            VoteTypeEntity voteTypeEntity = VoteTypeEntity.builder().name(voteTypeName).build();
            voteTypeDao.save(voteTypeEntity);
        }
    }
}
