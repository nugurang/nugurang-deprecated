package com.nugurang.graphql;

import com.nugurang.dao.BoardDao;
import com.nugurang.dao.ProjectDao;
import com.nugurang.dao.TeamDao;
import com.nugurang.dao.UserDao;
import com.nugurang.entity.BoardEntity;
import com.nugurang.entity.ProjectEntity;
import com.nugurang.entity.TeamEntity;
import com.nugurang.entity.UserEntity;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class Query implements GraphQLQueryResolver {
    private final BoardDao boardDao;
    private final ProjectDao projectDao;
    private final TeamDao teamDao;
    private final UserDao userDao;

    Optional<BoardEntity> getBoard(Long id) {
        return boardDao.findById(id);
    }

    Optional<ProjectEntity> getProject(Long id) {
        return projectDao.findById(id);
    }

    Optional<TeamEntity> getTeam(Long id) {
        return teamDao.findById(id);
    }

    Optional<UserEntity> getUser(Long id) {
        return userDao.findById(id);
    }
}
