package com.nugurang.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"team", "name"}))
public class Project implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "team", nullable = false)
    private Team team;

    @ManyToOne
    @JoinColumn(name = "event")
    private Event event;

    @OneToMany(mappedBy = "project", orphanRemoval = true)
    private List<Work> works = new ArrayList<>();

    public Project(Team team, String name) {
        this.team = team;
        this.name = name;
    }

    public Project(Team team, String name, Event event) {
        this(team, name);
        this.event = event;
    }
}
