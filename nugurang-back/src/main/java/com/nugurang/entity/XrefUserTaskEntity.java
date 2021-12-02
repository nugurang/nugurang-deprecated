package com.nugurang.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Table(
    name = "xref_user_task",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user", "task"})
    }
)
public class XrefUserTaskEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "task", nullable = false)
    private TaskEntity task;

    @Builder
    public XrefUserTaskEntity(Integer honor, UserEntity user, TaskEntity task) {
        this.user = user;
        this.task = task;
    }
}
