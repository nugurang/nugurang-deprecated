package com.nugurang.graphql.mutation;

import com.nugurang.dto.UserDto;
import com.nugurang.dto.UserInputDto;
import com.nugurang.service.UserService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMutation implements GraphQLMutationResolver {

    private final UserService userService;

    UserDto createCurrentUser(UserInputDto userInputDto) {
        return userService.createUser(userInputDto).toDto();
    }

    UserDto updateCurrentUser(UserInputDto userInputDto) {
        return userService.updateCurrentUser(userInputDto).toDto();
    }

    Long deleteUser(Long userId) {
        return userService.deleteUser(userId);
    }

    Long deleteCurrentUser() {
        return userService.deleteCurrentUser();
    }
}
