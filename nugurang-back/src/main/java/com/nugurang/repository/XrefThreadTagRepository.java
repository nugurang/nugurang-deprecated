package com.nugurang.repository;

import com.nugurang.entity.XrefThreadTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XrefThreadTagRepository extends JpaRepository<XrefThreadTag, Long> {

}
