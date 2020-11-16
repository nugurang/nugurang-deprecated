package com.nugurang.graphql;

import com.nugurang.dto.PositionDto;
import com.nugurang.dto.UserDto;
import com.nugurang.dto.UserEvaluationDto;
import com.nugurang.dto.UserReviewDto;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserReviewResolver implements GraphQLResolver<UserReviewDto> {

    public PositionDto position(UserReviewDto userReviewDto) {
        return null;
    }

    public UserDto fromUser(UserReviewDto userReviewDto) {
        return null;
    }

    public UserDto toUser(UserReviewDto userReviewDto) {
        return null;
    }

    public UserEvaluationDto evaluation(UserReviewDto userReviewDto) {
        return null;
    }
}
