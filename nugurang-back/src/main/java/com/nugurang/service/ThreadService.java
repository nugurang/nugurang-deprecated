package com.nugurang.service;


import com.nugurang.dao.ArticleDao;
import com.nugurang.dao.ThreadDao;
import com.nugurang.dao.VoteTypeDao;
import com.nugurang.dto.VoteInputDto;
import com.nugurang.entity.ArticleEntity;
import com.nugurang.entity.ThreadEntity;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ThreadService {

    private final VoteService voteService;
    private final UserService userService;
    private final ArticleDao articleDao;
    private final ThreadDao threadDao;
    private final VoteTypeDao voteTypeDao;

    @Transactional
    public Optional<ThreadEntity> getThread(Long id) {
        Optional<ThreadEntity> threadEntity = threadDao.findById(id);
        if (!threadEntity.isPresent())
            return Optional.empty();
        
        ArticleEntity articleEntity = articleDao.findFirstByThreadIdOrderByCreatedAtAsc(threadEntity.get().getId());
        if (voteService.getVote(userService.getCurrentUser().get().getId(), articleEntity.getId(), "VIEW").isPresent())
            return threadEntity;
        voteService.createVote(VoteInputDto
            .builder()
            .article(articleEntity.getId())
            .voteType(voteTypeDao.findByName("VIEW").get().getId())
            .build()
        );
        return threadEntity;
    }
}
