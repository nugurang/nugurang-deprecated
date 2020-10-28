package com.nugurang.dao;

import com.nugurang.entity.TeamEntity;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeamDaoCustom {

    public Page<TeamEntity> findAllByUserId(Long user, Pageable pageable);
}
