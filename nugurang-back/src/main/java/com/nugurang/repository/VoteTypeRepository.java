package com.nugurang.repository;

import com.nugurang.entity.VoteType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteTypeRepository extends JpaRepository<VoteType, Long> {

}
