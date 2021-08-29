package com.nugurang.graphql.resolver;

import com.nugurang.dao.ArticleDao;
import com.nugurang.dao.BoardDao;
import com.nugurang.dao.ImageDao;
import com.nugurang.dao.NotificationDao;
import com.nugurang.dao.ProjectDao;
import com.nugurang.dao.TeamDao;
import com.nugurang.dao.ThreadDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dao.UserHonorDao;
import com.nugurang.dto.ArticleDto;
import com.nugurang.dto.BoardDto;
import com.nugurang.dto.ImageDto;
import com.nugurang.dto.NotificationDto;
import com.nugurang.dto.ProjectDto;
import com.nugurang.dto.TeamDto;
import com.nugurang.dto.ThreadDto;
import com.nugurang.dto.UserDto;
import com.nugurang.dto.UserEvaluationDto;
import com.nugurang.dto.UserHonorDto;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserResolver implements GraphQLResolver<UserDto> {
    private final ArticleDao articleDao;
    private final BoardDao boardDao;
    private final ImageDao imageDao;
    private final ProjectDao projectDao;
    private final TeamDao teamDao;
    private final ThreadDao threadDao;
    private final UserDao userDao;
    private final UserHonorDao userHonorDao;
    private final NotificationDao notificationDao;

    public Integer totalHonor(UserDto userDto) {
        return userHonorDao
            .findAllByUserId(userDto.getId())
            .stream()
            .mapToInt((entity) -> entity.toDto().getHonor())
            .sum();
    }

    public List<UserHonorDto> honors(UserDto userDto) {
        return userHonorDao
            .findAllByUserId(userDto.getId())
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    public Optional<ImageDto> image(UserDto userDto) {
        return Optional.ofNullable(
            userDao
            .findById(userDto.getId())
            .get()
            .getImage()
        )
        .map((imageEntity) -> imageEntity.toDto());
    }

    public BoardDto blog(UserDto userDto) {
        return userDao
            .findById(userDto.getId())
            .get()
            .getBlog()
            .toDto();
    }

    public List<ArticleDto> getArticles(UserDto userDto, Integer page, Integer pageSize) {
        return articleDao
            .findAllByUserId(userDto.getId(), PageRequest.of(page, pageSize))
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    public List<UserDto> getFollowings(UserDto userDto, Integer page, Integer pageSize) {
        return userDao
            .findAllByFollowerId(userDto.getId(), PageRequest.of(page, pageSize))
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    public List<UserDto> getFollowers(UserDto userDto, Integer page, Integer pageSize) {
        return userDao
            .findAllByFollowingId(userDto.getId(), PageRequest.of(page, pageSize))
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    public List<NotificationDto> getNotifications(UserDto userDto, Integer page, Integer pageSize) {
        return notificationDao
            .findAllByUserId(userDto.getId(), PageRequest.of(page, pageSize))
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    public List<ProjectDto> getProjects(UserDto userDto, Integer page, Integer pageSize) {
        return projectDao
            .findAllByUserId(userDto.getId(), PageRequest.of(page, pageSize))
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    public List<TeamDto> getTeams(UserDto userDto, Integer page, Integer pageSize) {
        return teamDao
            .findAllByUserId(userDto.getId(), PageRequest.of(page, pageSize))
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    public List<ThreadDto> getThreads(UserDto userDto, Integer page, Integer pageSize) {
        return threadDao
            .findAllByUserId(userDto.getId(), PageRequest.of(page, pageSize))
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    public List<UserEvaluationDto> getUserEvaluations(UserDto userDto, Integer page, Integer pageSize) {
        return projectDao
            .findAllByUserId(userDto.getId(), PageRequest.of(page, pageSize))
            .stream()
            .map((projectEntity) -> Optional.ofNullable(projectEntity.getUserEvaluation()))
            .filter((userEvaluationEntity) -> userEvaluationEntity.isPresent())
            .map((entity) -> entity.get().toDto())
            .collect(Collectors.toList());
    }
}
