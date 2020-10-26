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
import com.nugurang.dto.ImageDto;
import com.nugurang.dto.TeamDto;
import com.nugurang.dto.ThreadDto;
import com.nugurang.dto.UserDto;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ThreadResolver implements GraphQLResolver<ThreadDto> {
    private final ArticleDao articleDao;
    private final BoardDao boardDao;
    private final TeamDao teamDao;
    private final ThreadDao threadDao;
    private final UserDao userDao;
    private final EventDao eventDao;
    private final ArticleDao articledDao;

    public BoardDto board(ThreadDto threadDto) {
        return threadDao
            .findById(threadDto.getId())
            .map((threadEntity) -> threadEntity.getBoard())
            .map((boardEntity) -> boardEntity.toDto())
            .get();
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

    public List<ArticleDto> getArticles(ThreadDto threadDto, Integer page, Integer pageSize) {
        return articleDao
            .findAllByThreadIdOrderByCreatedAtAsc(threadDto.getId(), PageRequest.of(page, pageSize))
            .getContent()
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    public Integer upCount(ThreadDto threadDto) {
        return 0;
    }

    public Integer downCount(ThreadDto threadDto) {
        return 0;
    }

    public Integer starCount(ThreadDto threadDto) {
        return 0;
    }

    public Optional<ImageDto> image(ThreadDto threadDto) {
        return Optional.empty();
    }
}
