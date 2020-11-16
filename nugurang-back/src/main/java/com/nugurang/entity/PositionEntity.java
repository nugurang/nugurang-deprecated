package com.nugurang.entity;

import com.nugurang.dto.PositionDto;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "position")
public class PositionEntity implements BaseEntity<PositionDto> {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = true)
    private String description;

    @ManyToOne
    @JoinColumn(name = "image", nullable = true)
    private ImageEntity image;

    public PositionDto toDto() {
        return PositionDto
            .builder()
            .id(id)
            .name(name)
            .description(Optional.of(description))
            .build();
    }
}
