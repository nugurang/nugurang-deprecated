package com.nugurang.dao;

import com.nugurang.entity.ProjectEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectDaoCustom {
    Page<ProjectEntity> findAllByUserId(Long user, Pageable pageable);
}
