package com.nugurang.graphql;

import com.nugurang.dao.ArticleDao;
import com.nugurang.dao.BoardDao;
import com.nugurang.dao.EventDao;
import com.nugurang.dao.TeamDao;
import com.nugurang.dao.ThreadDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dto.ArticleDto;
import com.nugurang.dto.BoardDto;
import com.nugurang.dto.EventDto;
import com.nugurang.dto.TeamDto;
import com.nugurang.dto.ThreadDto;
import com.nugurang.dto.UserDto;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ThreadResolver implements GraphQLResolver<ThreadDto> {
    private final ThreadDao threadDao;
    private final BoardDao boardDao;
    private final UserDao userDao;
    private final TeamDao teamDao;
    private final EventDao eventDao;
    private final ArticleDao articledDao;

    public BoardDto board(ThreadDto threadDto) {
        return threadDao
            .findById(threadDto.getId())
            .map((threadEntity) ->
                threadEntity.getBoard()
            )
            .map((boardEntity) ->
                BoardDto.builder()
                .id(boardEntity.getId())
                .name(boardEntity.getName())
                .build()
            ).get();
    }

    public UserDto user(ThreadDto threadDto) {
        return null;
    }

    public TeamDto team(ThreadDto threadDto) {
        return null;
    }

    public EventDto event(ThreadDto threadDto) {
        return null;
    }

    public List<ArticleDto> articles(ThreadDto threadDto, int page, int pageSize) {
        int pageStart = page * pageSize;
        int pageEnd = pageStart + pageSize - 1;
        return null;
    }

}
