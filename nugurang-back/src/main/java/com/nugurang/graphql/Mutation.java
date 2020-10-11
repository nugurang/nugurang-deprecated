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
import graphql.kickstart.tools.GraphQLMutationResolver;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class Mutation implements GraphQLMutationResolver {
    private final BoardDao boardDao;
    private final ProjectDao projectDao;
    private final TeamDao teamDao;
    private final UserDao userDao;

    Optional<BoardDto> createBoard(String name) {
        BoardEntity boardEntity = BoardEntity.builder().name(name).build();
        boardEntity = boardDao.save(boardEntity);
        return Optional.of(
             BoardDto.builder()
            .id(boardEntity.getId())
            .name(boardEntity.getName())
            .build()
        );

    }
}
