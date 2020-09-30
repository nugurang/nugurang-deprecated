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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user", "task"})
})
public class XrefUserTask implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer honor;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "task", nullable = false)
    private Task task;

    public XrefUserTask(Integer honor, User user, Task task) {
        this.honor = honor;
        this.user = user;
        this.task = task;
    }
}
