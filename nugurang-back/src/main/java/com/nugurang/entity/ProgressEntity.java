package com.nugurang.entity;

import com.nugurang.dto.ProgressDto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "progress")
public class ProgressEntity implements BaseEntity<ProgressDto> {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "progress", cascade = CascadeType.ALL)
    private List<TaskEntity> tasks = new ArrayList<>();

    @Builder
    public ProgressEntity(String name) {
        this.name = name;
    }

    public ProgressDto toDto() {
        return ProgressDto
            .builder()
            .name(name)
            .build();
    }
}
