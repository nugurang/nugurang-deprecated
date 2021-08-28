package com.nugurang.service;

import com.nugurang.dao.BoardDao;
import com.nugurang.dto.BoardInputDto;
import com.nugurang.entity.BoardEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardDao boardDao;

    public BoardEntity createBoard(BoardInputDto boardInputDto) {
        return boardDao.save(
            BoardEntity
            .builder()
            .name(boardInputDto.getName())
            .build()
        );
    }

    public BoardEntity updateBoard(BoardInputDto boardInputDto, Long boardId) {
        BoardEntity boardEntity = boardDao.getById(boardId);
        boardEntity.setName(boardInputDto.getName());
        return boardDao.save(boardEntity);
    }

    public Long deleteBoard(Long id) {
        boardDao.deleteById(id);
        return id;
    }
}
