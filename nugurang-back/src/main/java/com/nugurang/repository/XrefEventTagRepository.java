package com.nugurang.repository;

import com.nugurang.entity.XrefEventTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XrefEventTagRepository extends JpaRepository<XrefEventTag, Long> {

}
