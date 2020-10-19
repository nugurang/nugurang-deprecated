package com.nugurang.dao;

import com.nugurang.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserDaoCustom {
    Page<UserEntity> findAllByBoardId(Long id, Pageable pageable);
}
