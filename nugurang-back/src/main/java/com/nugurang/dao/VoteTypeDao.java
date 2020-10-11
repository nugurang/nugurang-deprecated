package com.nugurang.dao;

import com.nugurang.entity.VoteTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteTypeDao extends JpaRepository<VoteTypeEntity, Long> {

}
