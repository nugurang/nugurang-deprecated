package com.nugurang.graphql;

import com.nugurang.dao.ProjectDao;
import com.nugurang.dto.ProjectDto;
import com.nugurang.dto.UserEvaluationDto;
import com.nugurang.dto.UserReviewDto;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserEvaluationResolver implements GraphQLResolver<UserEvaluationDto> {

    private final ProjectDao projectDao;

    public ProjectDto project(UserEvaluationDto userEvaluationDto) {
        return projectDao
            .findByUserEvaluationId(userEvaluationDto.getId())
            .get()
            .toDto();
    }

    public List<UserReviewDto> reviews(UserEvaluationDto userEvaluationDto) {
        return null;
    }
}
