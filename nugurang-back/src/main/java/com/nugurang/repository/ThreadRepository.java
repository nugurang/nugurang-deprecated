package com.nugurang.repository;

import com.nugurang.entity.ThreadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreadRepository extends JpaRepository<ThreadEntity, Long> {

}
