package com.nugurang.graphql;

import com.nugurang.dao.ArticleDao;
import com.nugurang.dao.BoardDao;
import com.nugurang.dao.EventDao;
import com.nugurang.dao.FollowingDao;
import com.nugurang.dao.ImageDao;
import com.nugurang.dao.PositionDao;
import com.nugurang.dao.ProgressDao;
import com.nugurang.dao.ProjectDao;
import com.nugurang.dao.RoleDao;
import com.nugurang.dao.TaskDao;
import com.nugurang.dao.TaskHonorDao;
import com.nugurang.dao.TeamDao;
import com.nugurang.dao.ThreadDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dao.UserEvaluationDao;
import com.nugurang.dao.UserHonorDao;
import com.nugurang.dao.UserReviewDao;
import com.nugurang.dao.WorkDao;
import com.nugurang.dao.XrefUserTaskDao;
import com.nugurang.dao.XrefUserTeamDao;
import com.nugurang.dto.ArticleDto;
import com.nugurang.dto.ArticleInputDto;
import com.nugurang.dto.BoardDto;
import com.nugurang.dto.EventDto;
import com.nugurang.dto.ImageDto;
import com.nugurang.dto.PositionDto;
import com.nugurang.dto.ProjectDto;
import com.nugurang.dto.ProjectInputDto;
import com.nugurang.dto.RoleDto;
import com.nugurang.dto.StarDto;
import com.nugurang.dto.TagDto;
import com.nugurang.dto.TaskDto;
import com.nugurang.dto.TaskInputDto;
import com.nugurang.dto.TeamDto;
import com.nugurang.dto.ThreadDto;
import com.nugurang.dto.ThreadInputDto;
import com.nugurang.dto.UserDto;
import com.nugurang.dto.UserInputDto;
import com.nugurang.dto.UserReviewInputDto;
import com.nugurang.dto.VoteDto;
import com.nugurang.dto.VoteTypeDto;
import com.nugurang.dto.WorkDto;
import com.nugurang.entity.BoardEntity;
import com.nugurang.entity.FollowingEntity;
import com.nugurang.entity.ImageEntity;
import com.nugurang.entity.PositionEntity;
import com.nugurang.entity.ProjectEntity;
import com.nugurang.entity.RoleEntity;
import com.nugurang.entity.TaskEntity;
import com.nugurang.entity.TaskHonorEntity;
import com.nugurang.entity.TeamEntity;
import com.nugurang.entity.ThreadEntity;
import com.nugurang.entity.UserEntity;
import com.nugurang.entity.UserEvaluationEntity;
import com.nugurang.entity.UserReviewEntity;
import com.nugurang.entity.WorkEntity;
import com.nugurang.entity.XrefUserTaskEntity;
import com.nugurang.entity.XrefUserTeamEntity;
import com.nugurang.service.ArticleService;
import com.nugurang.service.OAuth2Service;
import com.nugurang.service.UserService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {
    private final ArticleService articleService;
    private final OAuth2Service oauth2Service;
    private final UserService userService;
    private final ArticleDao articleDao;
    private final BoardDao boardDao;
    private final FollowingDao followingDao;
    private final ImageDao imageDao;
    private final PositionDao positionDao;
    private final ProgressDao progressDao;
    private final ProjectDao projectDao;
    private final RoleDao roleDao;
    private final TaskDao taskDao;
    private final TaskHonorDao taskHonorDao;
    private final TeamDao teamDao;
    private final ThreadDao threadDao;
    private final UserDao userDao;
    private final UserEvaluationDao userEvaluationDao;
    private final UserHonorDao userHonorDao;
    private final UserReviewDao userReviewDao;
    private final EventDao eventDao;
    private final WorkDao workDao;
    private final XrefUserTaskDao xrefUserTaskDao;
    private final XrefUserTeamDao xrefUserTeamDao;

    Optional<ArticleDto> createArticle(
        ArticleInputDto articleInputDto,
        Long thread,
        Optional<Long> parent
    ) {
        return Optional.of(
            articleService.createArticle(articleInputDto, thread, parent)
            .toDto()
        );
    }

    Optional<BoardDto> createBoard(String name) {
        BoardEntity boardEntity = BoardEntity.builder().name(name).build();
        boardEntity = boardDao.save(boardEntity);
        return Optional.of(boardEntity.toDto());
    }

    Optional<EventDto> createEvent(Long board, String name, String content, List<Long> images) {
        return Optional.empty();
    }

    Boolean createFollowing(Long user) {
        UserEntity fromUser = userService.getCurrentUser().get();
        UserEntity toUser = userDao.findById(user).get();
        if (fromUser.getId() == toUser.getId())
            return false;
        followingDao.save(FollowingEntity
            .builder()
            .fromUser(fromUser)
            .toUser(toUser)
            .build());
        return true;
    }

    Optional<ImageDto> createImage(String address) {
        ImageEntity imageEntity = imageDao.save(
            ImageEntity
            .builder()
            .address(address)
            .build()
        );
        return Optional.of(imageEntity.toDto());
    }

    Optional<PositionDto> createPosition(String name) {
        return Optional.of(
            positionDao.save(
                PositionEntity
                .builder()
                .name(name)
                .build()
            ).toDto()
        );
    }

    Optional<ProjectDto> createProject(Long team, ProjectInputDto projectInputDto) {
        return Optional.of(
            projectDao
            .save(
                ProjectEntity
                .builder()
                .name(projectInputDto.getName())
                .finished(false)
                .team(teamDao.findById(team).get())
                .event(
                    projectInputDto
                    .getEvent()
                    .flatMap((id) -> eventDao.findById(id)).orElse(null)
                )
                .build()
            )
            .toDto()
        );
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

    @Transactional
    Optional<TaskDto> createTask(TaskInputDto taskInputDto) {
        TaskEntity taskEntity = taskDao.save(
            TaskEntity
            .builder()
            .name(taskInputDto.getName())
            .order(taskInputDto.getOrder().orElse(0))
            .work(workDao.findById(taskInputDto.getWork()).get())
            .progress(
                taskInputDto
                .getProgress()
                .flatMap((progressId) -> progressDao.findById(progressId))
                .orElseGet(() -> progressDao.findByName("TODO").get())
            )
            .build()
        );

        xrefUserTaskDao.saveAll(
            taskInputDto
            .getUsers()
            .stream()
            .map((userId) -> userDao.findById(userId).get())
            .map((userEntity) ->
                XrefUserTaskEntity
                .builder()
                .user(userEntity)
                .task(taskEntity)
                .build()
            )
            .collect(Collectors.toList())
        );

        taskHonorDao.saveAll(
            taskInputDto
            .getPositions()
            .stream()
            .map((positionId) ->
                positionDao.findById(positionId).get()
            )
            .map((positionEntity) ->
                TaskHonorEntity
                .builder()
                .honor(0)
                .task(taskEntity)
                .position(positionEntity)
                .build()
            )
            .collect(Collectors.toList())
        );

        return Optional.of(taskEntity.toDto());
    }

    Optional<TeamDto> createTeam(String name) {
        UserEntity userEntity = userService.getCurrentUser().get();

        TeamEntity teamEntity = teamDao.save(
            TeamEntity
            .builder()
            .name(name)
            .build()
        );

        RoleEntity roleEntity = roleDao.findByName("OWNER").get();

        xrefUserTeamDao.save(
            XrefUserTeamEntity
            .builder()
            .user(userEntity)
            .team(teamEntity)
            .role(roleEntity)
            .build()
        );

        return Optional.of(teamEntity.toDto());
    }

    @Transactional
    Optional<ThreadDto> createThread(ThreadInputDto threadInputDto) {
        UserEntity userEntity = userService.getCurrentUser().get();
        ThreadEntity threadEntity = threadDao.save(
            ThreadEntity
            .builder()
            .name(threadInputDto.getName())
            .board(boardDao.findById(threadInputDto.getBoard()).get())
            .xrefUserTeam(
                threadInputDto
                .getTeam()
                .map((teamId) ->
                    xrefUserTeamDao
                    .findByUserIdAndTeamId(userEntity.getId(), teamId)
                    .get()
                )
                .orElse(null)
            )
            .event(
                threadInputDto
                .getEvent()
                .flatMap((eventId) -> eventDao.findById(eventId))
                .orElse(null)
            )
            .user(userEntity)
            .build()
        );

        articleService.createArticle(
            threadInputDto.getArticle(),
            threadEntity.getId(),
            Optional.empty()
        );

        return Optional.of(threadEntity.toDto());
    }

    Optional<UserDto> createUser(UserInputDto userInputDto) {
        UserEntity userEntity = UserEntity
            .builder()
            .oauth2Provider(oauth2Service.getProvider())
            .oauth2Id(oauth2Service.getId())
            .name(userInputDto.getName())
            .email(userInputDto.getEmail())
            .biography(userInputDto.getBiography())
            .image(userInputDto.getImage().flatMap((id) -> imageDao.findById(id)).orElse(null))
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

    Optional<WorkDto> createWork(Long project, String name, Optional<Integer> order) {
        return Optional.of(
            workDao.save(
                WorkEntity
                .builder()
                .name(name)
                .opened(true)
                .order(order.orElse(0))
                .project(projectDao.findById(project).get())
                .build()
            )
            .toDto()
        );
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
        OffsetDateTime recruitingStart, OffsetDateTime recruitingEnd,
        OffsetDateTime eventStart, OffsetDateTime eventEnd) {
        return Optional.empty();
    }

    Optional<ProjectDto> updateProject(Long project, ProjectInputDto projectInputDto) {
        return Optional.of(
            projectDao
            .findById(project)
            .map((projectEntity) -> {
                projectEntity.setName(projectInputDto.getName());
                projectEntity.setEvent(
                    projectInputDto
                    .getEvent()
                    .flatMap((id) -> eventDao.findById(id)).orElse(null)
                );
                return projectEntity;
            })
            .get()
            .toDto()
        );
    }

    Boolean updateProjectFinish(Long project) {
        ProjectEntity projectEntity = projectDao.findById(project).get();
        if (projectEntity.getFinished())
            return false;

        UserEvaluationEntity userEvaluationEntity = userEvaluationDao.save(
            UserEvaluationEntity
            .builder()
            .days(7)
            .build()
        );

        projectEntity.setFinished(true);
        projectEntity.setUserEvaluation(userEvaluationEntity);

        return true;
    }
    
    Optional<TaskDto> updateTask(Long id, TaskInputDto taskInputDto) {
        return Optional.empty();
    }

    Boolean updateTaskReview(Long task, Integer honor) {
        return false;
    }

    Optional<TeamDto> updateTeam(Long team, String name, List<Long> users) {
        return Optional.empty();
    }

    Optional<ThreadDto> updateThread(Long thread, Long board, String name, Long event) {
        return Optional.empty();
    }

    Optional<UserDto> updateUser(UserInputDto userInputDto) {
        return Optional.of(
            userService
            .getCurrentUser()
            .map((userEntity) -> {
                userEntity.setName(userInputDto.getName());
                userEntity.setEmail(userInputDto.getEmail());
                userEntity.setBiography(userInputDto.getBiography());
                userEntity.setImage(
                    userInputDto
                    .getImage()
                    .flatMap((id) -> imageDao.findById(id)).orElse(null)
                );
                return userDao.save(userEntity);
            })
            .get()
            .toDto()
        );
    }

    @Transactional
    Boolean updateUserReviews(Long project, List<UserReviewInputDto> userReviews) {
        UserEntity fromUser = userService.getCurrentUser().get();
        ProjectEntity projectEntity = projectDao.findById(project).get();
        UserEvaluationEntity userEvaluationEntity = projectEntity.getUserEvaluation();
        if (userEvaluationEntity == null)
            return false;

        List<UserReviewEntity> userReviewEntities = userReviewDao.saveAll(
            userReviews
            .stream()
            .flatMap((userReviewInputDto) ->
                userReviewInputDto
                .getHonors()
                .stream()
                .map((positionHonorInputDto) ->
                    userReviewDao.save(
                        UserReviewEntity
                        .builder()
                        .honor(positionHonorInputDto.getHonor())
                        .fromUser(fromUser)
                        .toUser(
                            userDao.findById(userReviewInputDto.getToUser())
                            .get()
                        )
                        .position(
                            positionDao
                            .findById(positionHonorInputDto.getPosition())
                            .get()
                        )
                        .userEvaluation(userEvaluationEntity)
                        .build()
                    )
                )
            )
            .collect(Collectors.toList())
        );

        return true;
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

    Boolean deleteFollowing(Long user) {
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
