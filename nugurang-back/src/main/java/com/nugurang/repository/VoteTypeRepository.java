package com.nugurang.repository;

import com.nugurang.entity.VoteTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteTypeRepository extends JpaRepository<VoteTypeEntity, Long> {

}
