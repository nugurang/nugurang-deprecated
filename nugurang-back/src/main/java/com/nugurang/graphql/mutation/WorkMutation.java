package com.nugurang.graphql.mutation;

import com.nugurang.dto.WorkDto;
import com.nugurang.dto.WorkInputDto;
import com.nugurang.service.WorkService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkMutation implements GraphQLMutationResolver {

    private final WorkService workService;

    public WorkDto createWork(WorkInputDto workInputDto, Long projectId) {
        return workService.createWork(workInputDto, projectId).toDto();
    }

    public WorkDto updateWork(WorkInputDto workInputDto, Long workId) {
        return workService.updateWork(workInputDto, workId).toDto();
    }

    public Long deleteWork(Long workId) {
        workService.deleteWork(workId);
        return workId;
    }
}
