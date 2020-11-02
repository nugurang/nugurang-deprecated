package com.nugurang.dao;

import com.nugurang.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserDaoCustom {

    Page<UserEntity> findAllByBoardId(Long board, Pageable pageable);

    Page<UserEntity> findAllByFollowerId(Long follower, Pageable pageable);

    Page<UserEntity> findAllByFollowingId(Long following, Pageable pageable);

    Page<UserEntity> findAllByProjectId(Long project, Pageable pageable);

    Page<UserEntity> findAllByTeamId(Long team, Pageable pageable);
}
