package com.nugurang.graphql.mutation;

import com.nugurang.dto.ThreadDto;
import com.nugurang.dto.ThreadInputDto;
import com.nugurang.exception.NotFoundException;
import com.nugurang.service.ThreadService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ThreadMutation implements GraphQLMutationResolver {

    private final ThreadService threadService;

    public ThreadDto createThread(ThreadInputDto threadInputDto, Long board) {
        try {
            return threadService.createThread(threadInputDto, board).toDto();
        } catch (NotFoundException nfe) {
            throw com.nugurang.graphql.exception.NotFoundException
                .builder()
                .message(nfe.getMessage())
                .objectName(nfe.getObjectName())
                .build();
        }
    }

    public ThreadDto updateThread(ThreadInputDto threadInputDto, Long id) {
        return threadService.updateThread(threadInputDto, id).toDto();
    }

    public Long deleteThread(Long id) {
        threadService.deleteThread(id);
        return id;
    }
}
