package com.nugurang.config;

import com.nugurang.dao.ArticleDao;
import com.nugurang.dao.BoardDao;
import com.nugurang.dao.ThreadDao;
import com.nugurang.dao.UserDao;
import com.nugurang.entity.ArticleEntity;
import com.nugurang.entity.BoardEntity;
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

    @PostConstruct
    public void init() {
        List<String> boardNames = List.of(
            "competition", "study", "hobby", "circle", "activity", "startup"
        );
        for (String boardName : boardNames) {
            BoardEntity board = BoardEntity.builder().name(boardName).build();
            boardDao.save(board);
        }
    }
}
