package com.nugurang.graphql;

import com.nugurang.dao.BoardDao;
import com.nugurang.dao.ProjectDao;
import com.nugurang.dao.TeamDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dto.BoardDto;
import com.nugurang.dto.ProjectDto;
import com.nugurang.dto.TeamDto;
import com.nugurang.dto.UserDto;
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
public class Query implements GraphQLQueryResolver {
    private final BoardDao boardDao;
    private final ProjectDao projectDao;
    private final TeamDao teamDao;
    private final UserDao userDao;

    Optional<BoardDto> getBoard(Long id) {
        return boardDao
            .findById(id)
            .map((boardEntity) -> 
                BoardDto.builder()
                .id(boardEntity.getId())
                .name(boardEntity.getName())
                .build()
            );
    }

    Optional<ProjectDto> getProject(Long id) {
        return projectDao
            .findById(id)
            .map((projectEntity) -> 
                ProjectDto.builder()
                .id(projectEntity.getId())
                .name(projectEntity.getName())
                .build()
            );
    }

    Optional<TeamDto> getTeam(Long id) {
        return teamDao
            .findById(id)
            .map((teamEntity) -> 
                TeamDto.builder()
                .id(teamEntity.getId())
                .name(teamEntity.getName())
                .build()
            );
    }

    Optional<UserDto> getUser(Long id) {
        return userDao
            .findById(id)
            .map((userEntity) -> 
                UserDto.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .build()
            );
    }
}
