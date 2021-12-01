package com.nugurang.service;

import com.nugurang.dao.ArticleDao;
import com.nugurang.dao.VoteDao;
import com.nugurang.dao.VoteTypeDao;
import com.nugurang.dto.VoteInputDto;
import com.nugurang.entity.VoteEntity;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final UserService userService;
    private final ArticleDao articleDao;
    private final VoteDao voteDao;
    private final VoteTypeDao voteTypeDao;

    public Optional<VoteEntity> getVote(Long userId, Long articleId, String voteTypeName) {
        return voteDao.findByUserIdAndArticleIdAndVoteTypeName(userId, articleId, voteTypeName);
    }

    public VoteEntity createVote(VoteInputDto voteInputDto) {
        // TODO: Prevent users vote their own articles
        return voteDao.save(
            VoteEntity
            .builder()
            .user(userService.getCurrentUser().get())
            .article(articleDao.findById(voteInputDto.getArticle()).get())
            .voteType(voteTypeDao.findById(voteInputDto.getVoteType()).get())
            .build()
        );
    }

    public VoteEntity updateVote(VoteInputDto voteInputDto, Long voteId) {
        VoteEntity voteEntity = voteDao.findById(voteId).get();
        voteEntity.setUser(userService.getCurrentUser().get());
        voteEntity.setArticle(articleDao.findById(voteInputDto.getArticle()).get());
        voteEntity.setVoteType(voteTypeDao.findById(voteInputDto.getVoteType()).get());
        return voteDao.save(voteEntity);
    }

    public void deleteVote(Long id) {
        voteDao.deleteById(id);
    }
}
