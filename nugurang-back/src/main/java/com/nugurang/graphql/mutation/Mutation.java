package com.nugurang.graphql.mutation;

import com.nugurang.constant.InvitationStatusName;
import com.nugurang.constant.RoleName;
import com.nugurang.constant.UserEvaluationConstant;
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
import com.nugurang.dao.UserDao;
import com.nugurang.dao.UserEvaluationDao;
import com.nugurang.dao.UserHonorDao;
import com.nugurang.dao.UserReviewDao;
import com.nugurang.dao.XrefUserProjectDao;
import com.nugurang.dao.XrefUserTeamDao;
import com.nugurang.dto.MatchRequestDto;
import com.nugurang.dto.MatchRequestInputDto;
import com.nugurang.dto.PositionDto;
import com.nugurang.dto.PositionInputDto;
import com.nugurang.dto.ProjectInvitationDto;
import com.nugurang.dto.ProjectInvitationInputDto;
import com.nugurang.dto.TagDto;
import com.nugurang.dto.TagInputDto;
import com.nugurang.dto.TaskReviewInputDto;
import com.nugurang.dto.TeamInvitationDto;
import com.nugurang.dto.TeamInvitationInputDto;
import com.nugurang.dto.UserReviewInputDto;
import com.nugurang.entity.FollowingEntity;
import com.nugurang.entity.MatchRequestEntity;
import com.nugurang.entity.PositionEntity;
import com.nugurang.entity.ProjectEntity;
import com.nugurang.entity.ProjectInvitationEntity;
import com.nugurang.entity.TaskEntity;
import com.nugurang.entity.TaskReviewEntity;
import com.nugurang.entity.TeamEntity;
import com.nugurang.entity.TeamInvitationEntity;
import com.nugurang.entity.UserEvaluationEntity;
import com.nugurang.entity.UserHonorEntity;
import com.nugurang.entity.UserReviewEntity;
import com.nugurang.entity.XrefUserProjectEntity;
import com.nugurang.entity.XrefUserTeamEntity;
import com.nugurang.service.NotificationService;
import com.nugurang.service.UserService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class Mutation implements GraphQLMutationResolver {

    private final NotificationService notificationService;
    private final UserService userService;
    private final EventDao eventDao;
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
    private final TaskReviewDao taskReviewDao;
    private final TeamDao teamDao;
    private final TeamInvitationDao teamInvitationDao;
    private final UserDao userDao;
    private final UserEvaluationDao userEvaluationDao;
    private final UserHonorDao userHonorDao;
    private final UserReviewDao userReviewDao;
    private final XrefUserProjectDao xrefUserProjectDao;
    private final XrefUserTeamDao xrefUserTeamDao;

    Boolean createFollowing(Long user) {
        var fromUser = userService.getCurrentUser().get();
        var toUser = userDao.findById(user).get();
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

    MatchRequestDto createMatchRequest(MatchRequestInputDto matchRequestInputDto) {
        log.info("Creating match request...");
        var now = OffsetDateTime.now();
        return matchRequestDao.save(
            MatchRequestEntity
            .builder()
            .createdAt(now)
            .expiredAt(
                now
                .plusDays(matchRequestInputDto.getDays().orElse(1))
                .plusHours(matchRequestInputDto.getHours().orElse(0))
                .plusMinutes(matchRequestInputDto.getMinutes().orElse(0))
            )
            .minTeamSize(matchRequestInputDto.getMinTeamSize())
            .maxTeamSize(matchRequestInputDto.getMaxTeamSize().orElse(null))
            .type(matchTypeDao.findById(matchRequestInputDto.getType()).get())
            .event(eventDao.findById(matchRequestInputDto.getEvent()).get())
            .user(userService.getCurrentUser().get())
            .build()
        )
        .toDto();
    }

    PositionDto createPosition(PositionInputDto positionInputDto) {
        return positionDao.save(
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
        ).toDto();
    }

    List<ProjectInvitationDto> createProjectInvitations(ProjectInvitationInputDto projectInvitationInputDto) {
        final var currentUserEntity = userService.getCurrentUser().get();
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
                    userEntity,
                    projectInvitationEntity
                );
                return projectInvitationEntity.toDto();
            })
            .collect(Collectors.toList());
    }

    TagDto createTag(TagInputDto tagInputDto) {
        return null;
    }

    @Transactional
    List<TeamInvitationDto> createTeamInvitations(TeamInvitationInputDto teamInvitationInputDto) {
        final var currentUserEntity = userService.getCurrentUser().get();
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
                    userEntity,
                    teamInvitationEntity
                );

                return teamInvitationEntity.toDto();
            })
            .collect(Collectors.toList());
    }

    @Transactional
    Boolean updateProjectInvitationAccepted(Long projectInvitation) {
        var projectInvitationEntity = projectInvitationDao
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
        var projectInvitationEntity = projectInvitationDao
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
        var projectEntity = projectDao.findById(project).get();
        if (projectEntity.getFinished())
            return false;

        var now = OffsetDateTime.now();
        final var userEvaluationEntity = userEvaluationDao.save(
            UserEvaluationEntity
            .builder()
            .createdAt(now)
            .expiredAt(now.plusDays(UserEvaluationConstant.days))
            .build()
        );

        projectEntity.setFinished(true);
        projectEntity.setUserEvaluation(userEvaluationEntity);

        projectEntity = projectDao.save(projectEntity);
        for (TaskEntity taskEntity : taskDao.findAllByProjectId(project)) {
            final var taskReviewEntities = taskReviewDao.findAllByTaskId(taskEntity.getId());
           // log.info("task review entities size: " + taskReviewEntities.size());

            int honorPerPosition = taskReviewEntities.stream()
                .map((taskReviewEntity) -> taskEntity.getDifficulty() * taskReviewEntity.getHonor())
                .collect(Collectors.summingInt(Integer::intValue));

            if (taskReviewEntities.size() > 0)
                honorPerPosition /= taskReviewEntities.size();

            final var userEntities = userDao.findAllByTaskId(taskEntity.getId());
            // log.info("user entities size: " + userEntities.size());
            if (userEntities.size() > 0)
                honorPerPosition /= userEntities.size();

            for (final var userEntity : userEntities) {
                final var positionEntities = positionDao.findAllByTaskId(taskEntity.getId());
                // log.info("position entities size: " + positionEntities.size());

                if (positionEntities.size() > 0)
                    honorPerPosition /= positionEntities.size();

                // log.info("honor per position: " + honorPerPosition);

                for (final var positionEntity : positionEntities) {
                    UserHonorEntity userHonorEntity = userHonorDao.findByUserIdAndPositionId(
                        userEntity.getId(), positionEntity.getId()
                    ).orElseGet(() ->
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
    

    @Transactional
    Boolean updateTaskReview(TaskReviewInputDto taskReviewInputDto) {
        final var taskEntity = taskDao.findById(taskReviewInputDto.getTask()).get();
        final var userEntity = userService.getCurrentUser().get();

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

    Boolean updateTeamInvitationAccepted(Long teamInvitation) {
        var teamInvitationEntity = teamInvitationDao
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
        var teamInvitationEntity = teamInvitationDao
            .findById(teamInvitation)
            .get();

        teamInvitationEntity.setStatus(
            invitationStatusDao.findByName(InvitationStatusName.DENIED.name())
            .get()
        );

        teamInvitationDao.save(teamInvitationEntity);

        return true;
    }

    @Transactional
    Boolean updateUserReviews(List<UserReviewInputDto> userReviews, Long userEvaluation) {
        final var userEvaluationEntity = userEvaluationDao
            .findById(userEvaluation)
            .get();

        final var currentUserEntity = userService.getCurrentUser().get();

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

    Long deleteFollowing(Long user) {
        return user;
    }

    Long deleteRole(Long id) {
        return id;
    }

    Long deleteTag(Long id) {
        return id;
    }

    Long deleteVoteType(Long id) {
        return id;
    }

}
