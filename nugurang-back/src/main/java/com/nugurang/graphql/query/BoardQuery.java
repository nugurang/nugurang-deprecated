package com.nugurang.graphql.query;

import com.nugurang.dto.BoardDto;
import com.nugurang.exception.NotFoundException;
import com.nugurang.service.BoardService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardQuery implements GraphQLQueryResolver {

    private final BoardService boardService;

    Optional<BoardDto> getBoard(Long id) {
        try {
            return Optional.of(boardService.getBoard(id).toDto());
        } catch (NotFoundException nfe) {
            return Optional.empty();
        }
    }

    Optional<BoardDto> getBoardByName(String name) {
        return boardService.getBoard(name).map((entity) -> entity.toDto());
    }

    List<BoardDto> boards() {
        return boardService.getBoards()
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    List<BoardDto> getBoardsByNames(List<String> names) {
        return boardService.getBoards(names)
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }
}
