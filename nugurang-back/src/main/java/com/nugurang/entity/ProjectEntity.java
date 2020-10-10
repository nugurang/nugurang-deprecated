package com.nugurang.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(
    name = "project",
    uniqueConstraints = @UniqueConstraint(columnNames = {"team", "name"})
)
public class ProjectEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "team", nullable = false)
    private TeamEntity team;

    @ManyToOne
    @JoinColumn(name = "event")
    private EventEntity event;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<WorkEntity> works = new ArrayList<>();

    @Builder
    public ProjectEntity(TeamEntity team, String name, EventEntity event) {
        this.team = team;
        this.name = name;
        this.event = event;
    }
}
