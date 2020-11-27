package com.nugurang.dao;

import static com.nugurang.entity.QPositionEntity.positionEntity;
import static com.nugurang.entity.QUserHonorEntity.userHonorEntity;
import static com.nugurang.entity.QXrefTaskPositionEntity.xrefTaskPositionEntity;

import com.nugurang.entity.PositionEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PositionDaoImpl implements PositionDaoCustom {

    private final JPAQueryFactory queryFactory;

    public List<PositionEntity> findAllByTaskId(Long task) {
        return queryFactory
            .selectFrom(positionEntity)
            .innerJoin(xrefTaskPositionEntity)
            .on(positionEntity.id.eq(xrefTaskPositionEntity.position.id))
            .where(xrefTaskPositionEntity.task.id.eq(task))
            .fetch();
    }

    public List<PositionEntity> findAllByUserIdAndTaskId(Long user, Long task) {
        return queryFactory
            .selectFrom(positionEntity)
            .innerJoin(userHonorEntity)
            .on(positionEntity.id.eq(userHonorEntity.position.id))
            .innerJoin(xrefTaskPositionEntity)
            .on(positionEntity.id.eq(xrefTaskPositionEntity.position.id))
            .where(userHonorEntity.user.id.eq(user))
            .where(xrefTaskPositionEntity.task.id.eq(task))
            .fetch();
    }
}
