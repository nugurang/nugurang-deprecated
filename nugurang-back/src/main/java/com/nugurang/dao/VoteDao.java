package com.nugurang.dao;

import com.nugurang.entity.VoteEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteDao extends JpaRepository<VoteEntity, Long> {

    Long countByArticleIdAndVoteTypeId(Long article, Long voteType);

    Optional<VoteEntity> findByUserIdAndArticleIdAndVoteTypeName(Long user, Long article, String voteTypeName);
}
