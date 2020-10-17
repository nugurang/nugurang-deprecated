package com.nugurang.dao;

import com.nugurang.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
