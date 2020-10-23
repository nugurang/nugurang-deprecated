package com.nugurang.graphql;

import com.nugurang.dao.UserHonorDao;
import com.nugurang.dto.PositionDto;
import com.nugurang.dto.UserDto;
import com.nugurang.dto.UserHonorDto;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserHonorResolver implements GraphQLResolver<UserHonorDto> {
    private final UserHonorDao userHonorDao;

    public UserDto user(UserHonorDto userHonorDto) {
        return null;
    }

    public PositionDto position(UserHonorDto userHonorDto) {
        return null;
    }
}
