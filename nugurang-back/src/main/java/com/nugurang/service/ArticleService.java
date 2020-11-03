package com.nugurang.service;

import com.nugurang.dao.ArticleDao;
import com.nugurang.dao.ThreadDao;
import com.nugurang.dto.ArticleInputDto;
import com.nugurang.entity.ArticleEntity;
import com.nugurang.service.UserService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final UserService userService;
    private final ArticleDao articleDao;
    private final ThreadDao threadDao;

    public ArticleEntity createArticle(
        ArticleInputDto articleInputDto,
        Long thread,
        Optional<Long> parent
    ) {
        return articleDao.save(
            ArticleEntity
            .builder()
            .title(articleInputDto.getTitle().orElse(null))
            .content(articleInputDto.getContent())
            .user(userService.getCurrentUser().get())
            .thread(threadDao.findById(thread).get())
            .parent(
                parent
                .flatMap((parentId) -> articleDao.findById(parentId))
                .orElse(null)
             )
            .build()
        );
    }
}
