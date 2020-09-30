package com.nugurang.repository;

import com.nugurang.entity.Following;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowingRepository extends JpaRepository<Following, Long> {

}
