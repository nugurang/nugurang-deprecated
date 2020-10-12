package com.nugurang.graphql;

import com.nugurang.dao.UserDao;
import com.nugurang.dto.FollowingDto;
import com.nugurang.dto.UserDto;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FollowingResolver implements GraphQLResolver<FollowingDto> {

    private final UserDao userDao;

    public UserDto fromUser(FollowingDto followingDto) {
        return null;
    }

    public UserDto toUser(FollowingDto followingDto) {
        return null;
    }
}
