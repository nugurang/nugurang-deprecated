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
    name = "task_honor",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"task", "position"})
    }
)
public class TaskHonorEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private Integer honor;

    @ManyToOne
    @JoinColumn(name = "task", nullable = false)
    private TaskEntity task;

    @ManyToOne
    @JoinColumn(name = "position", nullable = false)
    private PositionEntity position;


    @Builder
    public TaskHonorEntity(Integer honor, TaskEntity task, PositionEntity position) {
        this.honor = honor;
        this.task = task;
        this.position = position;
    }
}
