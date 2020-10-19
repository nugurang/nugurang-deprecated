package com.nugurang.graphql;

import com.nugurang.dao.ArticleDao;
import com.nugurang.dao.BoardDao;
import com.nugurang.dao.ProjectDao;
import com.nugurang.dao.TeamDao;
import com.nugurang.dao.ThreadDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dto.ArticleDto;
import com.nugurang.dto.BoardDto;
import com.nugurang.dto.OAuth2UserDto;
import com.nugurang.dto.ProjectDto;
import com.nugurang.dto.TeamDto;
import com.nugurang.dto.ThreadDto;
import com.nugurang.dto.UserDto;
import com.nugurang.entity.ArticleEntity;
import com.nugurang.entity.BoardEntity;
import com.nugurang.entity.ProjectEntity;
import com.nugurang.entity.TeamEntity;
import com.nugurang.entity.UserEntity;
import com.nugurang.service.OAuth2Attributes;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {
    private final OAuth2Attributes oauth2Attributes;
    private final ArticleDao articleDao;
    private final BoardDao boardDao;
    private final ProjectDao projectDao;
    private final TeamDao teamDao;
    private final ThreadDao threadDao;
    private final UserDao userDao;

    String ping() {
        return "pong";
    }

    Optional<ArticleDto> article(Long id) {
        return articleDao
            .findById(id)
            .map((entity) -> entity.toDto());
    }

    Optional<BoardDto> board(Long id) {
        return boardDao
            .findById(id)
            .map((entity) -> entity.toDto());
    }

    Optional<ProjectDto> project(Long id) {
        return projectDao
            .findById(id)
            .map((entity) -> entity.toDto());
    }

    Optional<TeamDto> team(Long id) {
        return teamDao
            .findById(id)
            .map((entity) -> entity.toDto());
    }

    Optional<ThreadDto> thread(Long id) {
        return threadDao
            .findById(id)
            .map((entity) -> entity.toDto());
    }

    List<ThreadDto> threads(List<Long> boards, Integer page, Integer pageSize) {
        return threadDao
            .findAllByBoardIdInOrderByCreatedAtDesc(boards, PageRequest.of(page, pageSize))
            .getContent()
            .stream()
            .map((entity) -> entity.toDto())
            .collect(Collectors.toList());
    }

    Optional<UserDto> user(Long id) {
        return userDao
            .findById(id)
            .map((entity) -> entity.toDto());
    }

    Optional<UserDto> currentUser() {
        String provider = oauth2Attributes.getProvider();
        String id = oauth2Attributes.getId();
        return userDao
            .findByOauth2ProviderAndOauth2Id(provider, id)
            .map((entity) -> entity.toDto());
    }

    Optional<OAuth2UserDto> currentOAuth2User() {
        return Optional.of(
            OAuth2UserDto
            .builder()
            .provider(oauth2Attributes.getProvider())
            .id(oauth2Attributes.getId())
            .name(oauth2Attributes.getName())
            .email(oauth2Attributes.getEmail())
            .build()
        );
    }
}
