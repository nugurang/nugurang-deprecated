package com.nugurang.entity;

import com.nugurang.dto.TaskHonorDto;
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
    name = "task_honor",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"task", "position"})
    }
)
public class TaskHonorEntity implements BaseEntity<TaskHonorDto> {
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

    public TaskHonorDto toDto() {
        return TaskHonorDto
            .builder()
            .id(id)
            .honor(honor)
            .build();
    }
}
