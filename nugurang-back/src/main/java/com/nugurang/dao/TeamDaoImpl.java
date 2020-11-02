package com.nugurang.dao;

import static com.nugurang.entity.QTeamEntity.teamEntity;
import static com.nugurang.entity.QXrefUserTeamEntity.xrefUserTeamEntity;

import com.nugurang.entity.TeamEntity;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TeamDaoImpl implements TeamDaoCustom {

    private final JPAQueryFactory queryFactory;

    public Page<TeamEntity> findAllByUserId(Long user, Pageable pageable) {
        QueryResults<TeamEntity> results = queryFactory
            .selectFrom(teamEntity)
            .innerJoin(xrefUserTeamEntity)
            .on(teamEntity.id.eq(xrefUserTeamEntity.team.id))
            .where(xrefUserTeamEntity.user.id.eq(user))
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetchResults();
        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }
}
