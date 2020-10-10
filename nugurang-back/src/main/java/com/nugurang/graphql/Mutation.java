package com.nugurang.graphql;

import com.nugurang.entity.BoardEntity;
import com.nugurang.entity.ProjectEntity;
import com.nugurang.entity.TeamEntity;
import com.nugurang.entity.UserEntity;
import com.nugurang.repository.BoardRepository;
import com.nugurang.repository.ProjectRepository;
import com.nugurang.repository.TeamRepository;
import com.nugurang.repository.UserRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class Mutation implements GraphQLMutationResolver {
    private final BoardRepository boardRepository;
    private final ProjectRepository projectRepository;
    private final TeamRepository teamRepository;
    private final UserRepository userRepository;

    Optional<BoardEntity> createBoard(String name) {
        BoardEntity board = BoardEntity.builder().name(name).build();
        return Optional.of(boardRepository.save(board));
    }
}
