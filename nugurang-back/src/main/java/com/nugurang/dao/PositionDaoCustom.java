package com.nugurang.dao;

import com.nugurang.entity.PositionEntity;
import java.util.List;

public interface PositionDaoCustom {

    List<PositionEntity> findAllByTaskId(Long task);

    List<PositionEntity> findAllByUserIdAndTaskId(Long user, Long task);
}
