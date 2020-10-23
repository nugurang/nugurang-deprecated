package com.nugurang.dao;

import com.nugurang.entity.UserHonorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHonorDao extends JpaRepository<UserHonorEntity, Long> {

}
