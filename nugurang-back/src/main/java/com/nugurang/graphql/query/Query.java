package com.nugurang.graphql.query;

import com.nugurang.dao.EventDao;
import com.nugurang.dao.ImageDao;
import com.nugurang.dao.InvitationStatusDao;
import com.nugurang.dao.MatchRequestDao;
import com.nugurang.dao.MatchTypeDao;
import com.nugurang.dao.NotificationTypeDao;
import com.nugurang.dao.PositionDao;
import com.nugurang.dao.ProgressDao;
import com.nugurang.dao.ProjectInvitationDao;
import com.nugurang.dao.TeamInvitationDao;
import com.nugurang.dao.VoteTypeDao;
import com.nugurang.dto.EventDto;
import com.nugurang.dto.ImageDto;
import com.nugurang.dto.InvitationStatusDto;
import com.nugurang.dto.MatchRequestDto;
import com.nugurang.dto.MatchTypeDto;
import com.nugurang.dto.NotificationTypeDto;
import com.nugurang.dto.OAuth2UserDto;
import com.nugurang.dto.PositionDto;
import com.nugurang.dto.ProgressDto;
import com.nugurang.dto.ProjectInvitationDto;
import com.nugurang.dto.TeamInvitationDto;
import com.nugurang.dto.VoteTypeDto;
import com.nugurang.service.OAuth2Service;
import com.nugurang.service.UserService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {
    private final OAuth2Service oauth2Service;
    private final UserService userService;
    private final EventDao eventDao;
    private final ImageDao imageDao;
    private final InvitationStatusDao invitationStatusDao;
    private final MatchRequestDao matchRequestDao;
    private final MatchTypeDao matchTypeDao;
    private final NotificationTypeDao notificationTypeDao;
    private final PositionDao positionDao;
    private final ProgressDao progressDao;
    private final ProjectInvitationDao projectInvitationDao;
    private final TeamInvitationDao teamInvitationDao;
    private final VoteTypeDao voteTypeDao;

    String ping() {
        return "pong";
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

    List<MatchRequestDto> matchRequests() {
        return matchRequestDao.findAllByUserId(userService.getCurrentUser().get().getId())
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    List<InvitationStatusDto> invitationStatus() {
        return invitationStatusDao.findAll()
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    List<MatchTypeDto> matchTypes() {
        return matchTypeDao.findAll()
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    List<NotificationTypeDto> notificationTypes() {
        return notificationTypeDao.findAll()
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
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

    Optional<EventDto> getEvent(Long id) {
        return eventDao
            .findById(id)
            .map((entity) -> entity.toDto());
    }

    Optional<ImageDto> getImage(Long id) {
        return imageDao
            .findById(id)
            .map((entity) -> entity.toDto());
    }

    Optional<ImageDto> getImageByAddress(String address) {
        return imageDao
            .findByAddress(address)
            .map((entity) -> entity.toDto());
    }

    Optional<MatchTypeDto> getMatchTypeByName(String name) {
        return matchTypeDao
            .findByName(name)
            .map((entity) -> entity.toDto());
    }

    Optional<ProjectInvitationDto> getProjectInvitation(Long id) {
        return projectInvitationDao
            .findById(id)
            .map((entity) -> entity.toDto());
    }

    Optional<TeamInvitationDto> getTeamInvitation(Long id) {
        return teamInvitationDao
            .findById(id)
            .map((entity) -> entity.toDto());
    }

    Optional<VoteTypeDto> getVoteTypeByName(String name) {
        return voteTypeDao
            .findByName(name)
            .map((entity) -> entity.toDto());
    }
}
