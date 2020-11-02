package com.nugurang.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ThreadDaoImpl implements ThreadDaoCustom {

    private final JPAQueryFactory queryFactory;
}
