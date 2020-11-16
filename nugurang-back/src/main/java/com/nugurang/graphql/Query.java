package com.nugurang.graphql;

import com.nugurang.dao.ArticleDao;
import com.nugurang.dao.BoardDao;
import com.nugurang.dao.ImageDao;
import com.nugurang.dao.NotificationDao;
import com.nugurang.dao.PositionDao;
import com.nugurang.dao.ProgressDao;
import com.nugurang.dao.ProjectDao;
import com.nugurang.dao.TaskDao;
import com.nugurang.dao.TeamDao;
import com.nugurang.dao.ThreadDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dao.VoteTypeDao;
import com.nugurang.dao.WorkDao;
import com.nugurang.dto.ArticleDto;
import com.nugurang.dto.BoardDto;
import com.nugurang.dto.ImageDto;
import com.nugurang.dto.NotificationDto;
import com.nugurang.dto.OAuth2UserDto;
import com.nugurang.dto.PositionDto;
import com.nugurang.dto.ProgressDto;
import com.nugurang.dto.ProjectDto;
import com.nugurang.dto.TaskDto;
import com.nugurang.dto.TeamDto;
import com.nugurang.dto.ThreadDto;
import com.nugurang.dto.UserDto;
import com.nugurang.dto.VoteTypeDto;
import com.nugurang.dto.WorkDto;
import com.nugurang.service.OAuth2Service;
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
public class Query implements GraphQLQueryResolver {
    private final OAuth2Service oauth2Service;
    private final UserService userService;
    private final ArticleDao articleDao;
    private final BoardDao boardDao;
    private final ImageDao imageDao;
    private final NotificationDao notificationDao;
    private final PositionDao positionDao;
    private final ProgressDao progressDao;
    private final ProjectDao projectDao;
    private final TaskDao taskDao;
    private final TeamDao teamDao;
    private final ThreadDao threadDao;
    private final UserDao userDao;
    private final VoteTypeDao voteTypeDao;
    private final WorkDao workDao;

    String ping() {
        return "pong";
    }

    List<BoardDto> boards() {
        return boardDao.findAll()
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    Optional<UserDto> currentUser() {
        return userService
            .getCurrentUser()
            .map((entity) -> entity.toDto());
    }

    Optional<OAuth2UserDto> currentOAuth2User() {
        return Optional.of(
            OAuth2UserDto
            .builder()
            .provider(oauth2Service.getProvider())
            .id(oauth2Service.getId())
            .name(oauth2Service.getName())
            .email(oauth2Service.getEmail())
            .build()
        );
    }

    List<PositionDto> positions() {
        return positionDao.findAll()
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    List<ProgressDto> progresses() {
        return progressDao.findAll()
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    List<VoteTypeDto> voteTypes() {
        return voteTypeDao.findAll()
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    Optional<ArticleDto> getArticle(Long id) {
        return articleDao
            .findById(id)
            .map((entity) -> entity.toDto());
    }

    Optional<BoardDto> getBoard(Long id) {
        return boardDao
            .findById(id)
            .map((entity) -> entity.toDto());
    }

    Optional<BoardDto> getBoardByName(String name) {
        return boardDao
            .findByName(name)
            .map((entity) -> entity.toDto());
    }

    List<BoardDto> getBoardsByNames(List<String> names) {
        return boardDao
            .findAllByNameIn(names)
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    Optional<ImageDto> getImage(Long id) {
        return imageDao
            .findById(id)
            .map((entity) -> entity.toDto());
    }

    Optional<NotificationDto> getNotification(Long id) {
        return notificationDao
            .findById(id)
            .map((entity) -> entity.toDto());
    }

    Optional<ProjectDto> getProject(Long id) {
        return projectDao
            .findById(id)
            .map((entity) -> entity.toDto());
    }

    Optional<TeamDto> getTeam(Long id) {
        return teamDao
            .findById(id)
            .map((entity) -> entity.toDto());
    }

    Optional<TeamDto> getTeamByName(String name) {
        return teamDao
            .findByName(name)
            .map((entity) -> entity.toDto());
    }

    Optional<ThreadDto> getThread(Long id) {
        return threadDao
            .findById(id)
            .map((entity) -> entity.toDto());
    }

    List<ThreadDto> getThreadsByBoards(List<Long> boards, Integer page, Integer pageSize) {
        return threadDao
            .findAllByBoardIdInOrderByCreatedAtDesc(boards, PageRequest.of(page, pageSize))
            .getContent()
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    List<ThreadDto> getThreadsByBoardNames(List<String> boards, Integer page, Integer pageSize) {
        return threadDao
            .findAllByBoardNameInOrderByCreatedAtDesc(boards, PageRequest.of(page, pageSize))
            .getContent()
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    List<ThreadDto> getHotThreadsByBoardNames(List<String> boards, Integer page, Integer pageSize) {
        return threadDao
            .findAllByBoardNameInOrderByCreatedAtDesc(boards, PageRequest.of(page, pageSize))
            .getContent()
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    Optional<TaskDto> getTask(Long id) {
        return taskDao
            .findById(id)
            .map((entity) -> entity.toDto());
    }

    Optional<UserDto> getUser(Long id) {
        return userDao
            .findById(id)
            .map((entity) -> entity.toDto());
    }

    Optional<UserDto> getUserByName(String name) {
        return userDao
            .findByName(name)
            .map((entity) -> entity.toDto());
    }

    List<UserDto> getUsers(Integer page, Integer pageSize) {
        return userDao
            .findAll(PageRequest.of(page, pageSize))
            .getContent()
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    Optional<WorkDto> getWork(Long id) {
        return workDao
            .findById(id)
            .map((entity) -> entity.toDto());
    }

}
