package com.nugurang.dao;

import static com.nugurang.entity.QArticleEntity.articleEntity;
import static com.nugurang.entity.QThreadEntity.threadEntity;

import com.nugurang.entity.ThreadEntity;
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
public class ThreadDaoImpl implements ThreadDaoCustom {

    private final JPAQueryFactory queryFactory;
}
