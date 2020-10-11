package com.nugurang.dao;

import com.nugurang.entity.FollowingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowingDao extends JpaRepository<FollowingEntity, Long> {

}
