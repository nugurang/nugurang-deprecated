package com.nugurang.dao;

import static com.nugurang.entity.QBoardEntity.boardEntity;
import static com.nugurang.entity.QUserEntity.userEntity;
import static com.nugurang.entity.QXrefUserBoardEntity.xrefUserBoardEntity;

import com.nugurang.entity.UserEntity;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDaoCustom {

    private final JPAQueryFactory queryFactory;

    public Page<UserEntity> findAllByBoardId(Long id, Pageable pageable) {
        QueryResults<UserEntity> results = queryFactory
            .selectFrom(userEntity)
            .innerJoin(xrefUserBoardEntity)
            .on(userEntity.id.eq(xrefUserBoardEntity.user.id))
            .where(xrefUserBoardEntity.board.id.eq(id))
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetchResults();
        return new PageImpl<UserEntity>(results.getResults(), pageable, results.getTotal());
    }
}
