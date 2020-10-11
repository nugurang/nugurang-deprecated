package com.nugurang.dao;

import com.nugurang.entity.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteDao extends JpaRepository<VoteEntity, Long> {

}
