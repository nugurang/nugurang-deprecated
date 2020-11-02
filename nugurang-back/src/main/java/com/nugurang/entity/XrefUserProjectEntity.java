package com.nugurang.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(
    name = "xref_user_project",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user", "project"})
    }
)
public class XrefUserProjectEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "project", nullable = false)
    private ProjectEntity project;

    @ManyToOne
    @JoinColumn(name = "role", nullable = false)
    private RoleEntity role;

    @Builder
    public XrefUserProjectEntity(UserEntity user, ProjectEntity project, RoleEntity role) {
        this.user = user;
        this.project = project;
        this.role = role;
    }
}
