package com.nugurang.entity;

import java.io.Serializable;
import javax.persistence.Column;
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

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(
    name = "task",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"work", "name"}),
        @UniqueConstraint(columnNames = {"work", "name", "order"})
    }
) 
public class TaskEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private Integer order;

    @Column(nullable = false)
    private Integer difficulty;

    @ManyToOne
    @JoinColumn(name = "work", nullable = false)
    private WorkEntity work;

    @ManyToOne
    @JoinColumn(name = "progress", nullable = false)
    private ProgressEntity progress;

    @Builder
    public TaskEntity(
        String name, Integer order, Integer difficulty,
        WorkEntity work, ProgressEntity progress
    ) {
        this.name = name;
        this.order = order;
        this.difficulty = difficulty;
        this.work = work;
        this.progress = progress;
    }
}
