package com.nugurang.repository;

import com.nugurang.entity.StarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarRepository extends JpaRepository<StarEntity, Long> {

}
