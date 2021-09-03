package com.nugurang.service;

import com.nugurang.constant.RoleName;
import com.nugurang.dao.EventDao;
import com.nugurang.dao.ProjectDao;
import com.nugurang.dao.RoleDao;
import com.nugurang.dao.TeamDao;
import com.nugurang.dao.XrefUserProjectDao;
import com.nugurang.dto.ProjectInputDto;
import com.nugurang.entity.ProjectEntity;
import com.nugurang.entity.XrefUserProjectEntity;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final EventDao eventDao;
    private final RoleDao roleDao;
    private final ProjectDao projectDao;
    private final TeamDao teamDao;
    private final UserService userService;
    private final XrefUserProjectDao xrefUserProjectDao;

    @Transactional
    public ProjectEntity createProject(ProjectInputDto projectInputDto, Long teamId) {
        ProjectEntity projectEntity = projectDao.save(
            ProjectEntity
            .builder()
            .name(projectInputDto.getName())
            .finished(false)
            .team(teamDao.findById(teamId).get())
            .event(
                projectInputDto
                .getEvent()
                .flatMap((id) -> eventDao.findById(id)).orElse(null)
            )
            .build()
        );

        xrefUserProjectDao.save(
            XrefUserProjectEntity
            .builder()
            .user(userService.getCurrentUser().get())
            .project(projectEntity)
            .role(roleDao.findByName(RoleName.OWNER.name()).get())
            .build()
        );

        return projectEntity;
    }

    public Optional<ProjectEntity> getProject(Long projectId) {
        return projectDao.findById(projectId);
    }

    @Transactional
    public ProjectEntity updateProject(ProjectInputDto projectInputDto, Long projectId) {
        return projectDao.save(
            projectDao
            .findById(projectId)
            .map((projectEntity) -> {
                projectEntity.setName(projectInputDto.getName());
                projectEntity.setEvent(
                    projectInputDto
                    .getEvent()
                    .flatMap((eventId) -> eventDao.findById(eventId)).orElse(null)
                );
                return projectEntity;
            })
            .get()
        );
    }

    public void deleteProject(Long projectId) {
        projectDao.deleteById(projectId);
    }
}
