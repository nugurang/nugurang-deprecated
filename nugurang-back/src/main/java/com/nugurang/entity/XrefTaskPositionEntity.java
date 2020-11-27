package com.nugurang.entity;

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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(
    name = "xref_task_position",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"task", "position"})
    }
)
public class XrefTaskPositionEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task", nullable = false)
    private TaskEntity task;

    @ManyToOne
    @JoinColumn(name = "position", nullable = false)
    private PositionEntity position;
}
