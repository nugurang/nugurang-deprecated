package com.nugurang.graphql;

import com.nugurang.constant.InvitationStatusName;
import com.nugurang.constant.ProgressName;
import com.nugurang.constant.RoleName;
import com.nugurang.dao.ArticleDao;
import com.nugurang.dao.BoardDao;
import com.nugurang.dao.EventDao;
import com.nugurang.dao.FollowingDao;
import com.nugurang.dao.ImageDao;
import com.nugurang.dao.InvitationStatusDao;
import com.nugurang.dao.MatchRequestDao;
import com.nugurang.dao.MatchTypeDao;
import com.nugurang.dao.PositionDao;
import com.nugurang.dao.ProgressDao;
import com.nugurang.dao.ProjectDao;
import com.nugurang.dao.ProjectInvitationDao;
import com.nugurang.dao.RoleDao;
import com.nugurang.dao.TaskDao;
import com.nugurang.dao.TaskReviewDao;
import com.nugurang.dao.TeamDao;
import com.nugurang.dao.TeamInvitationDao;
import com.nugurang.dao.ThreadDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dao.UserEvaluationDao;
import com.nugurang.dao.UserHonorDao;
import com.nugurang.dao.UserReviewDao;
import com.nugurang.dao.VoteDao;
import com.nugurang.dao.VoteTypeDao;
import com.nugurang.dao.WorkDao;
import com.nugurang.dao.XrefTaskPositionDao;
import com.nugurang.dao.XrefUserProjectDao;
import com.nugurang.dao.XrefUserTaskDao;
import com.nugurang.dao.XrefUserTeamDao;
import com.nugurang.dto.ArticleDto;
import com.nugurang.dto.ArticleInputDto;
import com.nugurang.dto.BoardDto;
import com.nugurang.dto.BoardInputDto;
import com.nugurang.dto.EventDto;
import com.nugurang.dto.EventInputDto;
import com.nugurang.dto.ImageDto;
import com.nugurang.dto.MatchRequestDto;
import com.nugurang.dto.MatchRequestInputDto;
import com.nugurang.dto.PositionDto;
import com.nugurang.dto.PositionInputDto;
import com.nugurang.dto.ProjectDto;
import com.nugurang.dto.ProjectInputDto;
import com.nugurang.dto.ProjectInvitationDto;
import com.nugurang.dto.ProjectInvitationInputDto;
import com.nugurang.dto.TagDto;
import com.nugurang.dto.TagInputDto;
import com.nugurang.dto.TaskDto;
import com.nugurang.dto.TaskInputDto;
import com.nugurang.dto.TaskReviewInputDto;
import com.nugurang.dto.TeamDto;
import com.nugurang.dto.TeamInputDto;
import com.nugurang.dto.TeamInvitationDto;
import com.nugurang.dto.TeamInvitationInputDto;
import com.nugurang.dto.ThreadDto;
import com.nugurang.dto.ThreadInputDto;
import com.nugurang.dto.UserDto;
import com.nugurang.dto.UserInputDto;
import com.nugurang.dto.UserReviewInputDto;
import com.nugurang.dto.VoteDto;
import com.nugurang.dto.VoteInputDto;
import com.nugurang.dto.WorkDto;
import com.nugurang.dto.WorkInputDto;
import com.nugurang.entity.BoardEntity;
import com.nugurang.entity.EventEntity;
import com.nugurang.entity.FollowingEntity;
import com.nugurang.entity.ImageEntity;
import com.nugurang.entity.MatchRequestEntity;
import com.nugurang.entity.PositionEntity;
import com.nugurang.entity.ProjectEntity;
import com.nugurang.entity.ProjectInvitationEntity;
import com.nugurang.entity.TaskEntity;
import com.nugurang.entity.TaskReviewEntity;
import com.nugurang.entity.TeamEntity;
import com.nugurang.entity.TeamInvitationEntity;
import com.nugurang.entity.ThreadEntity;
import com.nugurang.entity.UserEntity;
import com.nugurang.entity.UserEvaluationEntity;
import com.nugurang.entity.UserHonorEntity;
import com.nugurang.entity.UserReviewEntity;
import com.nugurang.entity.VoteEntity;
import com.nugurang.entity.WorkEntity;
import com.nugurang.entity.XrefTaskPositionEntity;
import com.nugurang.entity.XrefUserProjectEntity;
import com.nugurang.entity.XrefUserTaskEntity;
import com.nugurang.entity.XrefUserTeamEntity;
import com.nugurang.service.ArticleService;
import com.nugurang.service.NotificationService;
import com.nugurang.service.OAuth2Service;
import com.nugurang.service.UserService;
import graphql.kickstart.tools.GraphQLMutationResolver;
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
    private final NotificationService notificationService;
    private final OAuth2Service oauth2Service;
    private final UserService userService;
    private final ArticleDao articleDao;
    private final BoardDao boardDao;
    private final FollowingDao followingDao;
    private final ImageDao imageDao;
    private final InvitationStatusDao invitationStatusDao;
    private final MatchRequestDao matchRequestDao;
    private final MatchTypeDao matchTypeDao;
    private final PositionDao positionDao;
    private final ProgressDao progressDao;
    private final ProjectDao projectDao;
    private final ProjectInvitationDao projectInvitationDao;
    private final RoleDao roleDao;
    private final TaskDao taskDao;
    private final XrefTaskPositionDao xrefTaskPositionDao;
    private final TaskReviewDao taskReviewDao;
    private final TeamDao teamDao;
    private final TeamInvitationDao teamInvitationDao;
    private final ThreadDao threadDao;
    private final UserDao userDao;
    private final UserEvaluationDao userEvaluationDao;
    private final UserHonorDao userHonorDao;
    private final UserReviewDao userReviewDao;
    private final VoteDao voteDao;
    private final VoteTypeDao voteTypeDao;
    private final EventDao eventDao;
    private final WorkDao workDao;
    private final XrefUserProjectDao xrefUserProjectDao;
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

    Optional<BoardDto> createBoard(BoardInputDto boardInputDto) {
        return Optional.of(
            boardDao.save(
                BoardEntity
                .builder()
                .name(boardInputDto.getName())
                .build()
            ).toDto()
        );
    }

    Optional<EventDto> createEvent(EventInputDto eventInputDto) {
        return Optional.of(
            eventDao.save(
                EventEntity
                .builder()
                .name(eventInputDto.getName())
                .description(eventInputDto.getDescription())
                .recruitingStart(eventInputDto.getRecruitingStart())
                .recruitingEnd(eventInputDto.getRecruitingEnd())
                .eventStart(eventInputDto.getEventStart())
                .eventEnd(eventInputDto.getEventEnd())
                .build()
            ).toDto()
        );
    }

    Boolean createFollowing(Long user) {
        UserEntity fromUser = userService.getCurrentUser().get();
        UserEntity toUser = userDao.findById(user).get();
        if (fromUser.getId() == toUser.getId())
            return false;
        followingDao.save(
            FollowingEntity
            .builder()
            .fromUser(fromUser)
            .toUser(toUser)
            .build()
        );
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

    Optional<MatchRequestDto> createMatchRequest(MatchRequestInputDto matchRequestInputDto) {
        return Optional.of(
            matchRequestDao.save(
                MatchRequestEntity
                .builder()
                .days(matchRequestInputDto.getDays())
                .minTeamSize(matchRequestInputDto.getMinTeamSize())
                .maxTeamSize(matchRequestInputDto.getMaxTeamSize().orElse(null))
                .type(matchTypeDao.findById(matchRequestInputDto.getType()).get())
                .event(eventDao.findById(matchRequestInputDto.getEvent()).get())
                .user(userService.getCurrentUser().get())
                .build()
            )
            .toDto()
        );
    }

    Optional<PositionDto> createPosition(PositionInputDto positionInputDto) {
        return Optional.of(
            positionDao.save(
                PositionEntity
                .builder()
                .name(positionInputDto.getName())
                .description(positionInputDto.getDescription().orElse(null))
                .image(
                    positionInputDto
                    .getImage()
                    .flatMap((imageId) -> imageDao.findById(imageId))
                    .orElse(null)
                )
                .build()
            ).toDto()
        );
    }

    @Transactional
    Optional<ProjectDto> createProject(ProjectInputDto projectInputDto, Long team) {
        ProjectEntity projectEntity = projectDao.save(
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
        );

        xrefUserProjectDao.save(
            XrefUserProjectEntity
            .builder()
            .user(userService.getCurrentUser().get())
            .project(projectEntity)
            .role(roleDao.findByName(RoleName.OWNER.name()).get())
            .build()
        );

        return Optional.of(projectEntity.toDto());
    }

    List<ProjectInvitationDto> createProjectInvitations(ProjectInvitationInputDto projectInvitationInputDto) {
        UserEntity currentUserEntity = userService.getCurrentUser().get();
        return projectInvitationInputDto
            .getUsers()
            .stream()
            .map((userId) -> userDao.findById(userId).get())
            .map((userEntity) -> {
                ProjectEntity projectEntity = projectDao
                    .findById(projectInvitationInputDto.getProject())
                    .get();

                ProjectInvitationEntity projectInvitationEntity = projectInvitationDao.save(
                    ProjectInvitationEntity
                    .builder()
                    .status(
                        invitationStatusDao
                        .findByName(InvitationStatusName.UNACCEPTED.name())
                        .get()
                    )
                    .project(projectEntity)
                    .fromUser(currentUserEntity)
                    .toUser(userEntity)
                    .build()
                );

                notificationService.createProjectInvitationNotification(
                    projectInvitationEntity,
                    userEntity
                );
                return projectInvitationEntity.toDto();
            })
            .collect(Collectors.toList());
    }

    Optional<TagDto> createTag(TagInputDto tagInputDto) {
        return Optional.empty();
    }

    @Transactional
    Optional<TaskDto> createTask(TaskInputDto taskInputDto, Long work) {
        TaskEntity taskEntity = taskDao.save(
            TaskEntity
            .builder()
            .name(taskInputDto.getName())
            .order(
                taskInputDto
                .getOrder()
                .orElseGet(() ->
                    taskDao
                    .findFirstByOrderByOrderDesc()
                    .map((prevTaskEntity) -> prevTaskEntity.getOrder() + 1)
                    .orElse(0)
                )
            )
            .difficulty(taskInputDto.getDifficulty().orElse(0))
            .work(workDao.findById(work).get())
            .progress(
                taskInputDto
                .getProgress()
                .map((progressId) -> progressDao.findById(progressId).get())
                .orElseGet(() -> progressDao.findByName(ProgressName.TODO.name()).get())
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

        xrefTaskPositionDao.saveAll(
            taskInputDto
            .getPositions()
            .stream()
            .map((positionId) ->
                positionDao.findById(positionId).get()
            )
            .map((positionEntity) ->
                XrefTaskPositionEntity
                .builder()
                .task(taskEntity)
                .position(positionEntity)
                .build()
            )
            .collect(Collectors.toList())
        );

        return Optional.of(taskEntity.toDto());
    }

    @Transactional
    Optional<TeamDto> createTeam(TeamInputDto teamInputDto) {

        TeamEntity teamEntity = teamDao.save(
            TeamEntity
            .builder()
            .name(teamInputDto.getName())
            .build()
        );

        xrefUserTeamDao.save(
            XrefUserTeamEntity
            .builder()
            .user(userService.getCurrentUser().get())
            .team(teamEntity)
            .role(roleDao.findByName(RoleName.OWNER.name()).get())
            .build()
        );

        return Optional.of(teamEntity.toDto());
    }

    @Transactional
    List<TeamInvitationDto> createTeamInvitations(TeamInvitationInputDto teamInvitationInputDto) {
        UserEntity currentUserEntity = userService.getCurrentUser().get();
        return teamInvitationInputDto
            .getUsers()
            .stream()
            .map((userId) -> userDao.findById(userId).get())
            .map((userEntity) -> {
                TeamEntity teamEntity = teamDao
                    .findById(teamInvitationInputDto.getTeam())
                    .get();


                TeamInvitationEntity teamInvitationEntity = teamInvitationDao.save(
                    TeamInvitationEntity
                    .builder()
                    .status(
                        invitationStatusDao
                        .findByName(InvitationStatusName.UNACCEPTED.name())
                        .get()
                    )
                    .team(teamEntity)
                    .fromUser(currentUserEntity)
                    .toUser(userEntity)
                    .build()
                );

                notificationService.createTeamInvitationNotification(
                    teamInvitationEntity, userEntity
                );

                return teamInvitationEntity.toDto();
            })
            .collect(Collectors.toList());
    }

    @Transactional
    Optional<ThreadDto> createThread(ThreadInputDto threadInputDto, Long board) {
        UserEntity userEntity = userService.getCurrentUser().get();
        ThreadEntity threadEntity = threadDao.save(
            ThreadEntity
            .builder()
            .name(threadInputDto.getName())
            .board(boardDao.findById(board).get())
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
            threadInputDto.getFirstArticle(),
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
            .blog(
                boardDao.save(
                    BoardEntity
                    .builder()
                    .name(userInputDto.getName())
                    .build()
                )
            )
            .build();
        userEntity = userDao.save(userEntity);
        return Optional.of(userEntity.toDto());
    }

    Optional<VoteDto> createVote(VoteInputDto voteInputDto) {
        return Optional.of(
            voteDao.save(
                VoteEntity
                .builder()
                .user(userService.getCurrentUser().get())
                .article(articleDao.findById(voteInputDto.getArticle()).get())
                .voteType(voteTypeDao.findById(voteInputDto.getVoteType()).get())
                .build()
            )
            .toDto()
        );
    }

    Optional<WorkDto> createWork(WorkInputDto workInputDto, Long project) {
        return Optional.of(
            workDao.save(
                WorkEntity
                .builder()
                .name(workInputDto.getName())
                .opened(true)
                .order(
                    workInputDto
                    .getOrder()
                    .orElseGet(() ->
                        workDao
                        .findFirstByOrderByOrderDesc()
                        .map((prevWorkEntity) -> prevWorkEntity.getOrder() + 1)
                        .orElse(0)
                    )
                )
                .project(projectDao.findById(project).get())
                .build()
            )
            .toDto()
        );
    }

    Optional<ArticleDto> updateArticle(ArticleInputDto articleInputDto, Long id)  {
        return Optional.empty();
    }

    Optional<BoardDto> updateBoard(BoardInputDto boardInputDto, Long id) {
        return Optional.empty();
    }

    Optional<EventDto> updateEvent(EventInputDto eventInputDto, Long id) {
        return Optional.empty();
    }

    Optional<ProjectDto> updateProject(ProjectInputDto projectInputDto, Long id) {
        return Optional.of(
            projectDao
            .findById(id)
            .map((projectEntity) -> {
                projectEntity.setName(projectInputDto.getName());
                projectEntity.setEvent(
                    projectInputDto
                    .getEvent()
                    .flatMap((eventId) -> eventDao.findById(eventId)).orElse(null)
                );
                return projectEntity;
            })
            .get()
            .toDto()
        );
    }

    @Transactional
    Boolean updateProjectInvitationAccepted(Long projectInvitation) {
        ProjectInvitationEntity projectInvitationEntity = projectInvitationDao
            .findById(projectInvitation)
            .get();

        projectInvitationEntity.setStatus(
            invitationStatusDao.findByName(InvitationStatusName.ACCEPTED.name())
            .get()
        );

        projectInvitationDao.save(projectInvitationEntity);

        xrefUserProjectDao.save(
            XrefUserProjectEntity
            .builder()
            .user(projectInvitationEntity.getToUser())
            .project(projectInvitationEntity.getProject())
            .role(roleDao.findByName(RoleName.MEMBER.name()).get())
            .build()
        );

        return true;
    }

    Boolean updateProjectInvitationDenied(Long projectInvitation) {
        ProjectInvitationEntity projectInvitationEntity = projectInvitationDao
            .findById(projectInvitation)
            .get();

        projectInvitationEntity.setStatus(
            invitationStatusDao.findByName(InvitationStatusName.DENIED.name())
            .get()
        );

        projectInvitationDao.save(projectInvitationEntity);

        return true;
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

        projectEntity = projectDao.save(projectEntity);
        for (TaskEntity taskEntity : taskDao.findAllByProjectId(project)) {
            int honorPerPosition = taskReviewDao
                .findAllByTaskId(taskEntity.getId())
                .stream()
                .map((taskReviewEntity) -> taskEntity.getDifficulty() * taskReviewEntity.getHonor())
                .collect(Collectors.summingInt(Integer::intValue));

            List<UserEntity> userEntities = userDao.findAllByTaskId(taskEntity.getId());
            if (userEntities.size() > 0)
                honorPerPosition /= userEntities.size();

            for (UserEntity userEntity : userEntities) {
                List<PositionEntity> positionEntities = positionDao.findAllByUserIdAndTaskId(
                    userEntity.getId(), taskEntity.getId()
                );

                if (positionEntities.size() > 0)
                    honorPerPosition /= positionEntities.size();

                for (PositionEntity positionEntity : positionEntities) {
                    UserHonorEntity userHonorEntity = userHonorDao.findByUserIdAndPositionId(
                        userEntity.getId(), positionEntity.getId()
                    ).orElse(
                        UserHonorEntity
                        .builder()
                        .user(userEntity)
                        .honor(0)
                        .position(positionEntity)
                        .build()
                    );
                    userHonorEntity.setHonor(userHonorEntity.getHonor() + honorPerPosition);
                    userHonorDao.save(userHonorEntity);
                }
            }
        }

        return true;
    }
    
    Optional<TaskDto> updateTask(TaskInputDto taskInputDto, Long id) {
        TaskEntity taskEntity = taskDao.findById(id).get();
        taskEntity.setName(taskInputDto.getName());

        if (taskInputDto.getOrder().isPresent())
            taskEntity.setOrder(taskInputDto.getOrder().get());

        if (taskInputDto.getDifficulty().isPresent())
            taskEntity.setDifficulty(taskInputDto.getDifficulty().get());

        if (taskInputDto.getProgress().isPresent()) {
            taskEntity.setProgress(
                progressDao.findById(taskInputDto.getProgress().get()).get()
            );
        }
        return Optional.of(taskDao.save(taskEntity).toDto());
    }

    @Transactional
    Boolean updateTaskReview(TaskReviewInputDto taskReviewInputDto) {
        TaskEntity taskEntity = taskDao.findById(taskReviewInputDto.getTask()).get();
        UserEntity userEntity = userService.getCurrentUser().get();

        taskReviewDao.deleteByTaskIdAndUserId(taskEntity.getId(), userEntity.getId());

        taskReviewDao.save(
            TaskReviewEntity
            .builder()
            .honor(taskReviewInputDto.getHonor())
            .task(taskEntity)
            .user(userEntity)
            .build()
        );

        return true;
    }

    @Transactional
    Optional<TeamDto> updateTeam(TeamInputDto teamInputDto, Long id) {
        TeamEntity teamEntity = teamDao.findById(id).get();
        teamEntity.setName(teamInputDto.getName());

        return Optional.of(
            teamDao.save(
                teamEntity
            )
            .toDto()
        );
    }

    Boolean updateTeamInvitationAccepted(Long teamInvitation) {
        TeamInvitationEntity teamInvitationEntity = teamInvitationDao
            .findById(teamInvitation)
            .get();

        teamInvitationEntity.setStatus(
            invitationStatusDao
            .findByName(InvitationStatusName.ACCEPTED.name())
            .get()
        );

        teamInvitationDao.save(teamInvitationEntity);

        xrefUserTeamDao.save(
            XrefUserTeamEntity
            .builder()
            .user(teamInvitationEntity.getToUser())
            .team(teamInvitationEntity.getTeam())
            .role(roleDao.findByName(RoleName.MEMBER.name()).get())
            .build()
        );

        return true;
    }

    Boolean updateTeamInvitationDenied(Long teamInvitation) {
        TeamInvitationEntity teamInvitationEntity = teamInvitationDao
            .findById(teamInvitation)
            .get();

        teamInvitationEntity.setStatus(
            invitationStatusDao.findByName(InvitationStatusName.DENIED.name())
            .get()
        );

        teamInvitationDao.save(teamInvitationEntity);

        return true;
    }

    Optional<ThreadDto> updateThread(ThreadInputDto threadInputDto, Long id) {
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
    Boolean updateUserReviews(List<UserReviewInputDto> userReviews, Long userEvaluation) {
        UserEvaluationEntity userEvaluationEntity = userEvaluationDao
            .findById(userEvaluation)
            .get();

        UserEntity currentUserEntity = userService.getCurrentUser().get();

        userReviews
            .stream()
            .map((userReviewInputDto) -> userReviewInputDto.getToUser())
            .forEach((toUser) ->
                userReviewDao.deleteByUserEvaluationIdAndFromUserIdAndToUserId(
                    userEvaluationEntity.getId(),
                    currentUserEntity.getId(),
                    toUser
                )
            );

        List<UserReviewEntity> userReviewEntities = userReviewDao.saveAll(
            userReviews
            .stream()
            .flatMap((userReviewInputDto) ->
                userReviewInputDto
                .getHonors()
                .stream()
                .map((positionHonorInputDto) ->
                    UserReviewEntity
                    .builder()
                    .honor(positionHonorInputDto.getHonor())
                    .fromUser(currentUserEntity)
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
            .collect(Collectors.toList())
        );

        return true;
    }

    Optional<VoteDto> updateVote(Long vote, List<Long> voteTypes) {
        return Optional.empty();
    }

    Optional<WorkDto> updateWork(WorkInputDto workInputDto, Long id) {
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
