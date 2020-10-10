package com.nugurang.repository;

import com.nugurang.entity.XrefEventTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XrefEventTagRepository extends JpaRepository<XrefEventTagEntity, Long> {

}
