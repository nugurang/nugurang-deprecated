package com.nugurang.entity;

import com.nugurang.dto.WorkDto;
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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(
    name = "work",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"project", "name"}),
        @UniqueConstraint(columnNames = {"project", "name", "order"})
    }
)
public class WorkEntity implements Serializable, BaseEntity<WorkDto> {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer order;

    @ManyToOne
    @JoinColumn(name = "project", nullable = false)
    private ProjectEntity project;

    @Builder
    public WorkEntity(String name, Integer order, ProjectEntity project) {
        this.name = name;
        this.order = order;
        this.project = project;
    }

    public WorkDto toDto() {
        return WorkDto
            .builder()
            .name(name)
            .order(order)
            .build();
    }
}
