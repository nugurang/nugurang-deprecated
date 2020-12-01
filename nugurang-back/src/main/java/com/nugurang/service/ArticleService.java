package com.nugurang.service;

import com.nugurang.dao.ArticleDao;
import com.nugurang.dao.ImageDao;
import com.nugurang.dao.ThreadDao;
import com.nugurang.dao.XrefArticleImageDao;
import com.nugurang.dto.ArticleInputDto;
import com.nugurang.entity.ArticleEntity;
import com.nugurang.entity.XrefArticleImageEntity;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final UserService userService;
    private final ArticleDao articleDao;
    private final ImageDao imageDao;
    private final ThreadDao threadDao;
    private final XrefArticleImageDao xrefArticleImageDao;

    @Transactional
    public ArticleEntity createArticle(
        ArticleInputDto articleInputDto,
        Long thread,
        Optional<Long> parent
    ) {
        val articleEntity = articleDao.save(
            ArticleEntity
            .builder()
            .title(articleInputDto.getTitle().orElse(null))
            .content(articleInputDto.getContent())
            .viewCount(0L)
            .user(userService.getCurrentUser().get())
            .thread(threadDao.findById(thread).get())
            .parent(
                parent
                .flatMap((parentId) -> articleDao.findById(parentId))
                .orElse(null)
             )
            .build()
        );

        xrefArticleImageDao.saveAll(
            articleInputDto
            .getImages()
            .stream()
            .map((imageId) ->
                XrefArticleImageEntity
                .builder()
                .article(articleEntity)
                .image(imageDao.findById(imageId).orElse(null))
                .build()
            )
            .collect(Collectors.toList())
        );

        return articleEntity;
    }
}
