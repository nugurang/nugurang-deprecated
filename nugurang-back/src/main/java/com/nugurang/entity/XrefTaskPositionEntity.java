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

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(
    name = "xref_task_position",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"task", "position"})
    }
)
public class XrefTaskPositionEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task", nullable = false)
    private TaskEntity task;

    @ManyToOne
    @JoinColumn(name = "position", nullable = false)
    private PositionEntity position;

    @Builder
    public XrefTaskPositionEntity(TaskEntity task, PositionEntity position) {
        this.task = task;
        this.position = position;
    }
}
