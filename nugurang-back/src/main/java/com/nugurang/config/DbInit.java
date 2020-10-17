package com.nugurang.config;

import com.nugurang.dao.ArticleDao;
import com.nugurang.dao.BoardDao;
import com.nugurang.dao.ThreadDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dao.VoteTypeDao;
import com.nugurang.entity.ArticleEntity;
import com.nugurang.entity.BoardEntity;
import com.nugurang.entity.VoteTypeEntity;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DbInit {
    private final UserDao userDao;
    private final BoardDao boardDao;
    private final ThreadDao threadDao;
    private final ArticleDao articleDao;
    private final VoteTypeDao voteTypeDao;

    @PostConstruct
    public void init() {
        for (String boardName
            : List.of("competition", "study", "hobby", "circle", "activity", "startup")) {
            BoardEntity board = BoardEntity.builder().name(boardName).build();
            boardDao.save(board);
        }
        for (String voteTypeName : List.of("up", "down")) {
            VoteTypeEntity voteTypeEntity = VoteTypeEntity.builder().name(voteTypeName).build();
            voteTypeDao.save(voteTypeEntity);
        }
    }
}
