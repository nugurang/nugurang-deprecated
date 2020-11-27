package com.nugurang.dao;

import static com.nugurang.entity.QTaskEntity.taskEntity;
import static com.nugurang.entity.QXrefUserTaskEntity.xrefUserTaskEntity;

import com.nugurang.entity.TaskEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TaskDaoImpl implements TaskDaoCustom {

    private final JPAQueryFactory queryFactory;

    public List<TaskEntity> findAllByUserId(Long user) {
        return queryFactory
            .selectFrom(taskEntity)
            .innerJoin(xrefUserTaskEntity)
            .on(taskEntity.id.eq(xrefUserTaskEntity.task.id))
            .where(xrefUserTaskEntity.user.id.eq(user))
            .fetch();
    }
}
