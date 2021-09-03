package com.nugurang.graphql.query;

import com.nugurang.dto.UserDto;
import com.nugurang.service.UserService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserQuery implements GraphQLQueryResolver {

    private final UserService userService;

    public Optional<UserDto> currentUser() {
        return userService
            .getCurrentUser()
            .map((entity) -> entity.toDto());
    }

    public Optional<UserDto> getUser(Long id) {
        return userService.getUser(id).map((entity) -> entity.toDto());
    }

    public Optional<UserDto> getUserByName(String name) {
        return userService.getUser(name).map((entity) -> entity.toDto());
    }

    public List<UserDto> getUsers(Integer page, Integer pageSize) {
        return userService
            .getUsers(PageRequest.of(page, pageSize))
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    public List<UserDto> getUsersByName(String name, Integer page, Integer pageSize) {
        return userService
            .getUsers(name, PageRequest.of(page, pageSize))
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }
}
