package com.nugurang.graphql;

import com.nugurang.dao.ArticleDao;
import com.nugurang.dao.BoardDao;
import com.nugurang.dao.EvaluationDao;
import com.nugurang.dao.EventDao;
import com.nugurang.dao.FollowingDao;
import com.nugurang.dao.ImageDao;
import com.nugurang.dao.PositionDao;
import com.nugurang.dao.ProjectDao;
import com.nugurang.dao.ReviewDao;
import com.nugurang.dao.RoleDao;
import com.nugurang.dao.TeamDao;
import com.nugurang.dao.ThreadDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dao.UserHonorDao;
import com.nugurang.dao.WorkDao;
import com.nugurang.dao.XrefUserTeamDao;
import com.nugurang.dto.ArticleDto;
import com.nugurang.dto.ArticleInputDto;
import com.nugurang.dto.BoardDto;
import com.nugurang.dto.EventDto;
import com.nugurang.dto.ImageDto;
import com.nugurang.dto.PositionDto;
import com.nugurang.dto.ProjectDto;
import com.nugurang.dto.RoleDto;
import com.nugurang.dto.StarDto;
import com.nugurang.dto.TagDto;
import com.nugurang.dto.TaskDto;
import com.nugurang.dto.TeamDto;
import com.nugurang.dto.ThreadDto;
import com.nugurang.dto.UserDto;
import com.nugurang.dto.UserHonorInputDto;
import com.nugurang.dto.VoteDto;
import com.nugurang.dto.VoteTypeDto;
import com.nugurang.dto.WorkDto;
import com.nugurang.entity.ArticleEntity;
import com.nugurang.entity.BoardEntity;
import com.nugurang.entity.EvaluationEntity;
import com.nugurang.entity.EventEntity;
import com.nugurang.entity.FollowingEntity;
import com.nugurang.entity.ImageEntity;
import com.nugurang.entity.PositionEntity;
import com.nugurang.entity.ProjectEntity;
import com.nugurang.entity.ReviewEntity;
import com.nugurang.entity.RoleEntity;
import com.nugurang.entity.TeamEntity;
import com.nugurang.entity.ThreadEntity;
import com.nugurang.entity.UserEntity;
import com.nugurang.entity.UserHonorEntity;
import com.nugurang.entity.WorkEntity;
import com.nugurang.entity.XrefUserTeamEntity;
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
    private final OAuth2Service oauth2Service;
    private final UserService userService;
    private final ArticleDao articleDao;
    private final BoardDao boardDao;
    private final EvaluationDao evaluationDao;
    private final FollowingDao followingDao;
    private final ImageDao imageDao;
    private final PositionDao positionDao;
    private final ProjectDao projectDao;
    private final ReviewDao reviewDao;
    private final RoleDao roleDao;
    private final TeamDao teamDao;
    private final ThreadDao threadDao;
    private final UserDao userDao;
    private final UserHonorDao userHonorDao;
    private final EventDao eventDao;
    private final WorkDao workDao;
    private final XrefUserTeamDao xrefUserTeamDao;

    Optional<ArticleDto> createArticle(ArticleInputDto articleInputDto) {
        ArticleEntity articleEntity = articleDao.save(
            ArticleEntity
            .builder()
            .title(articleInputDto.getTitle().orElse(null))
            .content(articleInputDto.getContent())
            .user(userService.getCurrentUser().get())
            .thread(threadDao.findById(articleInputDto.getThread()).get())
            .parent(
                articleInputDto
                .getParent()
                .flatMap((parent) -> articleDao.findById(parent))
                .orElse(null)
             )
            .build()
        );

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

    Optional<ProjectDto> createProject(Long team, String name, Optional<Long> event) {
        return Optional.of(
            projectDao
            .save(
                ProjectEntity
                .builder()
                .name(name)
                .team(teamDao.findById(team).get())
                .event(event.flatMap((id) -> eventDao.findById(id)).orElse(null))
                .build()
            )
            .toDto()
        );
    }

    @Transactional
    Boolean createReviews(Long project, List<UserHonorInputDto> honors) {
        UserEntity reviewer = userService.getCurrentUser().get();
        ProjectEntity projectEntity = projectDao.findById(project).get();
        EvaluationEntity evaluationEntity = evaluationDao.save(
            EvaluationEntity
            .builder()
            .project(projectEntity)
            .build()
        );

        List<ReviewEntity> reviewEntities = reviewDao.saveAll(
            honors.stream()
            .map((userHonorInputDto) ->
                userHonorDao.save(
                UserHonorEntity
                .builder()
                .honor(userHonorInputDto.getHonor())
                .user(userDao.findById(userHonorInputDto.getUser()).get())
                .position(positionDao.findById(userHonorInputDto.getPosition()).get())
                .build()
                )
            )
            .map((userHonorEntity) ->
                ReviewEntity
                .builder()
                .reviewer(reviewer)
                .userHonor(userHonorEntity)
                .evaluation(evaluationEntity)
                .build()
            )
            .collect(Collectors.toList())
        );

        return true;
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

    Optional<ThreadDto> createThread(Long board, String name, Long team, Long event) {
        UserEntity userEntity = userService.getCurrentUser().get();
        BoardEntity boardEntity = boardDao.findById(board).get();
        EventEntity eventEntity = eventDao.findById(event).orElse(null);
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

    Optional<UserDto> createUser(String name, String email, String biography, Optional<Long> image) {
        UserEntity userEntity = UserEntity
            .builder()
            .oauth2Provider(oauth2Service.getProvider())
            .oauth2Id(oauth2Service.getId())
            .name(name)
            .email(email)
            .biography(biography)
            .image(image.flatMap((id) -> imageDao.findById(id)).orElse(null))
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
