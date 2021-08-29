package com.nugurang.graphql.query;

import com.nugurang.dto.ThreadDto;
import com.nugurang.service.ThreadService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ThreadQuery implements GraphQLQueryResolver {

    private final ThreadService threadService;

    Optional<ThreadDto> getThread(Long id) {
        return threadService.getThread(id).map((entity) -> entity.toDto());
    }

    List<ThreadDto> getThreadsByBoards(List<Long> boards, Integer page, Integer pageSize) {
        return threadService
            .getThreadsByBoards(boards, page, pageSize)
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    List<ThreadDto> getThreadsByBoardNames(List<String> boards, Integer page, Integer pageSize) {
        return threadService
            .getThreadsByBoardNames(boards, page, pageSize)
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    List<ThreadDto> getHotThreadsByBoardNames(List<String> boards, Integer page, Integer pageSize) {
        return threadService
            .getHotThreadsByBoardNames(boards, page, pageSize)
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }
}
