package com.nugurang.dao;

import com.nugurang.entity.RoleEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findByName(String name);
}
