package com.nugurang.graphql.mutation;

import com.nugurang.dto.ThreadDto;
import com.nugurang.dto.ThreadInputDto;
import com.nugurang.service.ThreadService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ThreadMutation implements GraphQLMutationResolver {

    private final ThreadService threadService;

    public ThreadDto createThread(ThreadInputDto threadInputDto, Long board) {
        return threadService.createThread(threadInputDto, board).toDto();
    }

    Optional<ThreadDto> updateThread(ThreadInputDto threadInputDto, Long id) {
        return Optional.empty();
    }

    Boolean deleteThread(Long id) {
        return false;
    }
}
