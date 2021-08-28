package com.nugurang.graphql;

import com.nugurang.dto.BoardDto;
import com.nugurang.dto.BoardInputDto;
import com.nugurang.service.BoardService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardMutation implements GraphQLMutationResolver {

    private final BoardService boardService;

    BoardDto createBoard(BoardInputDto boardInputDto) {
        return boardService.createBoard(boardInputDto).toDto();
    }

    BoardDto updateBoard(BoardInputDto boardInputDto, Long boardId) {
        return boardService.updateBoard(boardInputDto, boardId).toDto();
    }

    Long deleteBoard(Long boardId) {
        return boardService.deleteBoard(boardId);
    }
}
