package com.nugurang.dao;

import com.nugurang.entity.UserEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByOauth2ProviderAndOauth2Id(String oauth2Provider, String oauth2Id);

    @Query("SELECT u FROM UserEntity u INNER JOIN XrefUserBoardEntity x ON u.id = x.user WHERE x.board.id = :board")
    Page<UserEntity> findAllByBoardId(@Param("board") Long id, Pageable pageable);
}
