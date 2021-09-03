package com.nugurang.dao;

import com.nugurang.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Long>, UserDaoCustom {

    Page<UserEntity> findAll(Pageable pageable);

    Page<UserEntity> findAllByNameContainingIgnoreCase(String name, Pageable pageable);

    Optional<UserEntity> findByOauth2ProviderAndOauth2Id(String oauth2Provider, String oauth2Id);

    Optional<UserEntity> findByName(String name);
}
