package com.nugurang.dao;

import static com.nugurang.entity.QFollowingEntity.followingEntity;
import static com.nugurang.entity.QUserEntity.userEntity;
import static com.nugurang.entity.QXrefUserBoardEntity.xrefUserBoardEntity;
import static com.nugurang.entity.QXrefUserProjectEntity.xrefUserProjectEntity;
import static com.nugurang.entity.QXrefUserTeamEntity.xrefUserTeamEntity;

import com.nugurang.entity.UserEntity;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDaoCustom {

    private final JPAQueryFactory queryFactory;

    public Page<UserEntity> findAllByBoardId(Long board, Pageable pageable) {
        QueryResults<UserEntity> results = queryFactory
            .selectFrom(userEntity)
            .innerJoin(xrefUserBoardEntity)
            .on(userEntity.id.eq(xrefUserBoardEntity.user.id))
            .where(xrefUserBoardEntity.board.id.eq(board))
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetchResults();
        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }

    public Page<UserEntity> findAllByFollowerId(Long follower, Pageable pageable) {
        QueryResults<UserEntity> results = queryFactory
            .selectFrom(userEntity)
            .innerJoin(followingEntity)
            .on(userEntity.id.eq(followingEntity.toUser.id))
            .where(followingEntity.fromUser.id.eq(follower))
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetchResults();
        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }

    public Page<UserEntity> findAllByFollowingId(Long following, Pageable pageable) {
        QueryResults<UserEntity> results = queryFactory
            .selectFrom(userEntity)
            .innerJoin(followingEntity)
            .on(userEntity.id.eq(followingEntity.fromUser.id))
            .where(followingEntity.toUser.id.eq(following))
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetchResults();
        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }

    public Page<UserEntity> findAllByProjectId(Long project, Pageable pageable) {
        QueryResults<UserEntity> results = queryFactory
            .selectFrom(userEntity)
            .innerJoin(xrefUserProjectEntity)
            .on(userEntity.id.eq(xrefUserProjectEntity.user.id))
            .where(xrefUserProjectEntity.project.id.eq(project))
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetchResults();

        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }

    public Page<UserEntity> findAllByTeamId(Long team, Pageable pageable) {
        QueryResults<UserEntity> results = queryFactory
            .selectFrom(userEntity)
            .innerJoin(xrefUserTeamEntity)
            .on(userEntity.id.eq(xrefUserTeamEntity.user.id))
            .where(xrefUserTeamEntity.team.id.eq(team))
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetchResults();
        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }
}
