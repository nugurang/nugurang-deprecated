package com.nugurang.graphql.query;

import com.nugurang.dto.WorkDto;
import com.nugurang.service.WorkService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkQuery implements GraphQLQueryResolver {

    private final WorkService workService;

    public Optional<WorkDto> getWork(Long id) {
        return workService.getWork(id).map((entity) -> entity.toDto());
    }
}
