package com.nugurang.entity;

import com.nugurang.dto.ProgressDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    public ProgressDto toDto() {
        return ProgressDto
            .builder()
            .id(id)
            .name(name)
            .build();
    }
}
