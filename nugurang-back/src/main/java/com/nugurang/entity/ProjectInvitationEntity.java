package com.nugurang.entity;

import com.nugurang.dto.ProjectInvitationDto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
    name = "project_invitation",
    uniqueConstraints = @UniqueConstraint(columnNames = {"project", "user"})
)
public class ProjectInvitationEntity implements BaseEntity<ProjectInvitationDto> {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "status")
    private InvitationStatusEntity status;

    @ManyToOne
    @JoinColumn(name = "project")
    private ProjectEntity project;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;

    @Override
    public ProjectInvitationDto toDto() {
        return ProjectInvitationDto
            .builder()
            .id(id)
            .build();
    }
}
