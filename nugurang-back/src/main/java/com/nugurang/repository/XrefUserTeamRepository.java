package com.nugurang.repository;

import com.nugurang.entity.XrefUserTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XrefUserTeamRepository extends JpaRepository<XrefUserTeam, Long> {

}
