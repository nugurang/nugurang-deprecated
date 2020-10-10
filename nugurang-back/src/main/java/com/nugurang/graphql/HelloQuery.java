package com.nugurang.graphql;

import com.nugurang.entity.Board;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.nugurang.repository.BoardRepository;

@Component
@RequiredArgsConstructor
class BoardQuery implements GraphQLQueryResolver {
    private final BoardRepository;
    Board getBoard(Long id) {
    }
}
