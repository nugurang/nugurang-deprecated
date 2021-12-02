package com.nugurang.entity;

import com.nugurang.dto.ProjectDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
@Table(
    name = "project",
    uniqueConstraints = @UniqueConstraint(columnNames = {"team", "name"})
)
public class ProjectEntity implements BaseEntity<ProjectDto> {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean finished;

    @ManyToOne
    @JoinColumn(name = "team", nullable = false)
    private TeamEntity team;

    @ManyToOne
    @JoinColumn(name = "event")
    private EventEntity event;

    @OneToOne
    @JoinColumn(name = "user_evaluation", unique = true)
    private UserEvaluationEntity userEvaluation;

    @Override
    public ProjectDto toDto() {
        return ProjectDto
            .builder()
            .id(id)
            .name(name)
            .finished(finished)
            .build();
    }
}
