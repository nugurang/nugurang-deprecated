package com.nugurang.dao;

import static com.nugurang.entity.QProjectEntity.projectEntity;
import static com.nugurang.entity.QTaskEntity.taskEntity;
import static com.nugurang.entity.QWorkEntity.workEntity;
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

    public List<TaskEntity> findAllByProjectId(Long project) {
        return queryFactory
            .selectFrom(taskEntity)
            .innerJoin(workEntity)
            .on(taskEntity.work.id.eq(workEntity.id))
            .innerJoin(projectEntity)
            .on(workEntity.project.id.eq(projectEntity.id))
            .where(projectEntity.id.eq(project))
            .fetch();
    }

    public List<TaskEntity> findAllByUserId(Long user) {
        return queryFactory
            .selectFrom(taskEntity)
            .innerJoin(xrefUserTaskEntity)
            .on(taskEntity.id.eq(xrefUserTaskEntity.task.id))
            .where(xrefUserTaskEntity.user.id.eq(user))
            .fetch();
    }
}
