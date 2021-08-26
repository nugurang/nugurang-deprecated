package com.nugurang.service;

import com.nugurang.dao.ArticleDao;
import com.nugurang.dao.ThreadDao;
import com.nugurang.entity.ArticleEntity;
import com.nugurang.entity.ThreadEntity;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ThreadService {

    private final ArticleDao articleDao;
    private final ThreadDao threadDao;

    @Transactional
    public Optional<ThreadEntity> getThread(Long id) {
        Optional<ThreadEntity> threadEntity = threadDao.findById(id);
        if (!threadEntity.isPresent())
            return Optional.empty();
        ArticleEntity articleEntity = articleDao.findFirstByThreadIdOrderByCreatedAtAsc(threadEntity.get().getId());
        articleEntity.setViewCount(articleEntity.getViewCount() + 1);
        articleDao.save(articleEntity);
        return threadEntity;
    }
}
