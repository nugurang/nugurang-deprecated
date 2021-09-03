package com.nugurang.service;

import com.nugurang.constant.RoleName;
import com.nugurang.dao.RoleDao;
import com.nugurang.dao.TeamDao;
import com.nugurang.dao.XrefUserTeamDao;
import com.nugurang.dto.TeamInputDto;
import com.nugurang.entity.TeamEntity;
import com.nugurang.entity.XrefUserTeamEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final UserService userService;
    private final RoleDao roleDao;
    private final TeamDao teamDao;
    private final XrefUserTeamDao xrefUserTeamDao;

    @Transactional
    public TeamEntity createTeam(TeamInputDto teamInputDto) {
        TeamEntity teamEntity = teamDao.save(
            TeamEntity
            .builder()
            .name(teamInputDto.getName())
            .build()
        );

        xrefUserTeamDao.save(
            XrefUserTeamEntity
            .builder()
            .user(userService.getCurrentUser().get())
            .team(teamEntity)
            .role(roleDao.findByName(RoleName.OWNER.name()).get())
            .build()
        );

        return teamEntity;
    }

    public TeamEntity updateTeam(TeamInputDto teamInputDto, Long id) {
        TeamEntity teamEntity = teamDao.findById(id).get();
        teamEntity.setName(teamInputDto.getName());
        return teamDao.save(teamEntity);
    }

    public void deleteTeam(Long teamId) {
        teamDao.deleteById(teamId);
    }
}
