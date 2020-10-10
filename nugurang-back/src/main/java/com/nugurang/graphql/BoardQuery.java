package com.nugurang.graphql;

import com.nugurang.entity.BoardEntity;
import com.nugurang.repository.BoardRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class BoardQuery implements GraphQLQueryResolver {
    private final BoardRepository boardRepository;
    /*
    Board getBoard(Long id) {
    }
    */
}
