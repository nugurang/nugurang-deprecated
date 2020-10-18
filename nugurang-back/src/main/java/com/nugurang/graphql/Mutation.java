package com.nugurang.graphql;

import com.nugurang.dao.ArticleDao;
import com.nugurang.dao.BoardDao;
import com.nugurang.dao.EventDao;
import com.nugurang.dao.ProjectDao;
import com.nugurang.dao.TeamDao;
import com.nugurang.dao.ThreadDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dto.ArticleDto;
import com.nugurang.dto.BoardDto;
import com.nugurang.dto.EventDto;
import com.nugurang.dto.FollowingDto;
import com.nugurang.dto.ImageDto;
import com.nugurang.dto.ProjectDto;
import com.nugurang.dto.RoleDto;
import com.nugurang.dto.StarDto;
import com.nugurang.dto.TagDto;
import com.nugurang.dto.TaskDto;
import com.nugurang.dto.TeamDto;
import com.nugurang.dto.ThreadDto;
import com.nugurang.dto.UserDto;
import com.nugurang.dto.VoteDto;
import com.nugurang.dto.VoteTypeDto;
import com.nugurang.dto.WorkDto;
import com.nugurang.entity.ArticleEntity;
import com.nugurang.entity.BoardEntity;
import com.nugurang.entity.EventEntity;
import com.nugurang.entity.ProjectEntity;
import com.nugurang.entity.TeamEntity;
import com.nugurang.entity.ThreadEntity;
import com.nugurang.entity.UserEntity;
import com.nugurang.service.OAuth2Attributes;
import graphql.kickstart.tools.GraphQLMutationResolver;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {
    private final OAuth2Attributes oauth2Attributes;
    private final ArticleDao articleDao;
    private final BoardDao boardDao;
    private final ProjectDao projectDao;
    private final TeamDao teamDao;
    private final ThreadDao threadDao;
    private final UserDao userDao;
    private final EventDao eventDao;

    Optional<ArticleDto> createArticle(String content, String title, Long thread, Long parent) {
        String oauth2Provider = oauth2Attributes.getProvider();
        String oauth2Id = oauth2Attributes.getId();
        UserEntity userEntity = userDao
            .findByOauth2ProviderAndOauth2Id(oauth2Provider, oauth2Id).get();
        ThreadEntity threadEntity = threadDao.findById(thread).get();
        ArticleEntity parentEntity = parent == null ? null : articleDao.findById(parent).get();
        ArticleEntity articleEntity = ArticleEntity
            .builder()
            .title(title)
            .content(content)
            .user(userEntity)
            .thread(threadEntity)
            .parent(parentEntity)
            .build();

        articleEntity = articleDao.save(articleEntity);

        return Optional.of(articleEntity.toDto());
    }

    Optional<BoardDto> createBoard(String name) {
        BoardEntity boardEntity = BoardEntity.builder().name(name).build();
        boardEntity = boardDao.save(boardEntity);
        return Optional.of(boardEntity.toDto());
    }

    Optional<EventDto> createEvent(Long board, String name, String content, List<Long> images) {
        return Optional.empty();
    }

    Optional<FollowingDto> createFollowing(Long fromUser, Long toUser) {
        return Optional.empty();
    }

    Optional<ImageDto> createImage(String address) {
        return Optional.empty();
    }

    Optional<ProjectDto> createProject(Long team, String name, Integer difficulty) {
        return Optional.empty();
    }

    Optional<RoleDto> createRole(String name) {
        return Optional.empty();
    }

    Optional<StarDto> createStar(Long user, Long article) {
        return Optional.empty();
    }

    Optional<TagDto> createTag(String name) {
        return Optional.empty();
    }

    Optional<TaskDto> createTask(Long work, String name, Integer difficulty) {
        return Optional.empty();
    }

    Optional<TeamDto> createTeam(String name) {
        return Optional.empty();
    }

    Optional<ThreadDto> createThread(Long board, String name, Long team, Long event) {
        String oauth2Provider = oauth2Attributes.getProvider();
        String oauth2Id = oauth2Attributes.getId();
        UserEntity userEntity = userDao
            .findByOauth2ProviderAndOauth2Id(oauth2Provider, oauth2Id).get();
        BoardEntity boardEntity = boardDao.findById(board).get();
        EventEntity eventEntity = event == null ? null : eventDao.findById(event).get();
        ThreadEntity threadEntity = ThreadEntity
            .builder()
            .name(name)
            .user(userEntity)
            .board(boardEntity)
            // .team(teamEntity)
            .event(eventEntity)
            .build();

        threadEntity = threadDao.save(threadEntity);

        return Optional.of(threadEntity.toDto());
    }

    Optional<UserDto> createUser(String name, String email, String biography, Long image) {
        UserEntity userEntity = UserEntity
            .builder()
            .oauth2Provider(oauth2Attributes.getProvider())
            .oauth2Id(oauth2Attributes.getId())
            .name(name)
            .email(email)
            .biography(biography)
            .build();
        userEntity = userDao.save(userEntity);
        return Optional.of(userEntity.toDto());
    }

    Optional<VoteDto> createVote(Long user, Long article, List<Long> voteTypes) {
        return Optional.empty();
    }

    Optional<VoteTypeDto> createVoteType(String name) {
        return Optional.empty();
    }

    Optional<WorkDto> createWork(Long project, String name) {
        return Optional.empty();
    }

    Optional<ArticleDto> updateArticle(
        Long article, Long thread, Long parent, String title, String content
    )  {
        return Optional.empty();
    }

    Optional<BoardDto> updateBoard(Long board, String name) {
        return Optional.empty();
    }

    Optional<EventDto> updateEvent(
        Long event, String title, String content, List<Long> images,
        LocalDateTime recruitingStart, LocalDateTime recruitingEnd,
        LocalDateTime eventStart, LocalDateTime eventEnd) {
        return Optional.empty();
    }

    Optional<ProjectDto> updateProject(Long project, Long team, String name, Long event) {
        return Optional.empty();
    }
    
    Optional<TaskDto> updateTask(
        Long task, Long work, String name, List<Long> users, Integer order,
        Integer progress, Integer difficulty, List<Long> positions
    ) {
        return Optional.empty();
    }

    Optional<TeamDto> updateTeam(Long team, String name, List<Long> users) {
        return Optional.empty();
    }

    Optional<ThreadDto> updateThread(Long thread, Long board, String name, Long event) {
        return Optional.empty();
    }

    Optional<UserDto> updateUser(
        Long user, String name, String email, Long image
    ) {
        return Optional.empty();
    }

    Optional<VoteDto> updateVote(Long vote, List<Long> voteTypes) {
        return Optional.empty();
    }

    Optional<WorkDto> updateWork(Long work, Long project, String name, Integer order) {
        return Optional.empty();
    }

    Boolean deleteArticle(Long id) {
        return false;
    }

    Boolean deleteBoard(Long id) {
        return false;
    }

    Boolean deleteEvent(Long id) {
        return false;
    }

    Boolean deleteFollowing(Long id) {
        return false;
    }

    Boolean deleteImage(Long id) {
        return false;
    }

    Boolean deleteProject(Long id) {
        return false;
    }

    Boolean deleteRole(Long id) {
        return false;
    }

    Boolean deleteTag(Long id) {
        return false;
    }

    Boolean deleteTask(Long id) {
        return false;
    }

    Boolean deleteTeam(Long id) {
        return false;
    }

    Boolean deleteThread(Long id) {
        return false;
    }

    Boolean deleteUser(Long id) {
        return false;
    }

    Boolean deleteVote(Long id) {
        return false;
    }

    Boolean deleteVoteType(Long id) {
        return false;
    }

    Boolean deleteWork(Long id) {
        return false;
    }
}
