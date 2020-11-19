package com.nugurang.graphql;

import com.nugurang.dao.UserReviewDao;
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

    private final UserReviewDao userReviewDao;

    public PositionDto position(UserReviewDto userReviewDto) {
        return userReviewDao
            .findById(userReviewDto.getId())
            .get()
            .getPosition()
            .toDto();
    }

    public UserDto fromUser(UserReviewDto userReviewDto) {
        return userReviewDao
            .findById(userReviewDto.getId())
            .get()
            .getFromUser()
            .toDto();
    }

    public UserDto toUser(UserReviewDto userReviewDto) {
        return userReviewDao
            .findById(userReviewDto.getId())
            .get()
            .getToUser()
            .toDto();
    }

    public UserEvaluationDto evaluation(UserReviewDto userReviewDto) {
        return userReviewDao
            .findById(userReviewDto.getId())
            .get()
            .getUserEvaluation()
            .toDto();
    }
}
