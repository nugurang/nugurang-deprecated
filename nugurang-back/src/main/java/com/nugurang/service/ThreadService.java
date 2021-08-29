package com.nugurang.service;

import com.nugurang.dao.ArticleDao;
import com.nugurang.dao.EventDao;
import com.nugurang.dao.ThreadDao;
import com.nugurang.dao.VoteTypeDao;
import com.nugurang.dao.XrefUserTeamDao;
import com.nugurang.dto.ThreadInputDto;
import com.nugurang.dto.VoteInputDto;
import com.nugurang.entity.ArticleEntity;
import com.nugurang.entity.ThreadEntity;
import com.nugurang.entity.UserEntity;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ThreadService {

    private final ArticleService articleService;
    private final BoardService boardService;
    private final UserService userService;
    private final VoteService voteService;
    private final ArticleDao articleDao;
    private final EventDao eventDao;
    private final ThreadDao threadDao;
    private final VoteTypeDao voteTypeDao;
    private final XrefUserTeamDao xrefUserTeamDao;

    @Transactional
    public ThreadEntity createThread(ThreadInputDto threadInputDto, Long board) {
        UserEntity userEntity = userService.getCurrentUser().get();
        ThreadEntity threadEntity = threadDao.save(
            ThreadEntity
            .builder()
            .name(threadInputDto.getName())
            .board(boardService.getBoard(board).get())
            .xrefUserTeam(
                threadInputDto
                .getTeam()
                .map((teamId) ->
                    xrefUserTeamDao
                    .findByUserIdAndTeamId(userEntity.getId(), teamId)
                    .get()
                )
                .orElse(null)
            )
            .event(
                threadInputDto
                .getEvent()
                .map((eventId) -> eventDao.getById(eventId))
                .orElse(null)
            )
            .user(userEntity)
            .build()
        );

        articleService.createArticle(
            threadInputDto.getFirstArticle(),
            threadEntity.getId(),
            Optional.empty()
        );

        return threadEntity;
    }

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

    public List<ThreadEntity> getThreadsByBoards(List<Long> boards, Integer page, Integer pageSize) {
        return threadDao
            .findAllByBoardIdInOrderByCreatedAtDesc(boards, PageRequest.of(page, pageSize))
            .getContent();
    }

    public List<ThreadEntity> getThreadsByBoardNames(List<String> boards, Integer page, Integer pageSize) {
        return threadDao
            .findAllByBoardNameInOrderByCreatedAtDesc(boards, PageRequest.of(page, pageSize))
            .getContent();
    }

    public List<ThreadEntity> getHotThreadsByBoardNames(List<String> boards, Integer page, Integer pageSize) {
        return threadDao
            .findAllByBoardNameInOrderByCreatedAtDesc(boards, PageRequest.of(page, pageSize))
            .getContent();
    }

    public ThreadEntity updateThread(ThreadInputDto threadInputDto, Long id) {
        return null;
    }

    public void deleteThread(Long id) {
        threadDao.deleteById(id);
    }
}
