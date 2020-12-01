package com.nugurang.dao;

import com.nugurang.entity.UserEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserDaoCustom {

    Optional<UserEntity> findFirstByTeamIdAndRoleId(Long team, Long role);

    Page<UserEntity> findAllByBoardId(Long board, Pageable pageable);

    Page<UserEntity> findAllByFollowerId(Long follower, Pageable pageable);

    Page<UserEntity> findAllByFollowingId(Long following, Pageable pageable);

    List<UserEntity> findAllByProjectId(Long project);

    Page<UserEntity> findAllByProjectId(Long project, Pageable pageable);

    List<UserEntity> findAllByProjectIdIn(List<Long> projects);

    List<UserEntity> findAllByTaskId(Long task);

    Page<UserEntity> findAllByTeamId(Long team, Pageable pageable);

    Page<UserEntity> findAllByTeamIdAndRoleId(Long team, Long role, Pageable pageable);
}
