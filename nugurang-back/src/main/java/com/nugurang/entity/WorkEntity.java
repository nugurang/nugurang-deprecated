package com.nugurang.entity;

import com.nugurang.dto.WorkDto;
import java.io.Serializable;
import javax.persistence.Column;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    private Boolean opened;

    @Column(nullable = false)
    private Integer order;

    @ManyToOne
    @JoinColumn(name = "project", nullable = false)
    private ProjectEntity project;

    public WorkDto toDto() {
        return WorkDto
            .builder()
            .id(id)
            .name(name)
            .opened(opened)
            .order(order)
            .build();
    }
}
