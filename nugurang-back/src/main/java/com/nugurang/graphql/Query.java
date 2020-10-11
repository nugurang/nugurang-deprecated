package com.nugurang.graphql;

import com.nugurang.entity.BoardEntity;
import com.nugurang.entity.ProjectEntity;
import com.nugurang.entity.TeamEntity;
import com.nugurang.entity.UserEntity;
import com.nugurang.repository.BoardRepository;
import com.nugurang.repository.ProjectRepository;
import com.nugurang.repository.TeamRepository;
import com.nugurang.repository.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class Query implements GraphQLQueryResolver {
    private final BoardRepository boardRepository;
    private final ProjectRepository projectRepository;
    private final TeamRepository teamRepository;
    private final UserRepository userRepository;

    Optional<BoardEntity> getBoard(Long id) {
        return boardRepository.findById(id);
    }

    Optional<ProjectEntity> getProject(Long id) {
        return projectRepository.findById(id);
    }

    Optional<TeamEntity> getTeam(Long id) {
        return teamRepository.findById(id);
    }

    Optional<UserEntity> getUser(Long id) {
        return userRepository.findById(id);
    }
}
