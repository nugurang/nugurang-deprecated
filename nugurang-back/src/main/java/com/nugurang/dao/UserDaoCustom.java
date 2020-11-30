package com.nugurang.dao;

import com.nugurang.entity.UserEntity;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserDaoCustom {

    Page<UserEntity> findAllByBoardId(Long board, Pageable pageable);

    Page<UserEntity> findAllByFollowerId(Long follower, Pageable pageable);

    Page<UserEntity> findAllByFollowingId(Long following, Pageable pageable);

    List<UserEntity> findAllByProjectId(Long project);

    Page<UserEntity> findAllByProjectId(Long project, Pageable pageable);

    List<UserEntity> findAllByProjectIdIn(List<Long> projects);

    List<UserEntity> findAllByTaskId(Long task);

    Page<UserEntity> findAllByTeamId(Long team, Pageable pageable);
}
