package com.nugurang.graphql;

import com.nugurang.dto.UserDto;
import com.nugurang.dto.UserInputDto;
import com.nugurang.service.UserService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMutation implements GraphQLMutationResolver {

    private final UserService userService;

    Optional<UserDto> createUser(UserInputDto userInputDto) {
        return Optional.of(userService.createUser(userInputDto).toDto());
    }

    Optional<UserDto> updateUser(UserInputDto userInputDto) {
        return Optional.of(userService.updateCurrentUser(userInputDto).toDto());
    }
}
