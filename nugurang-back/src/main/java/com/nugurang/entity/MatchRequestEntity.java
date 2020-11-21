package com.nugurang.entity;

import com.nugurang.dto.MatchRequestDto;
import java.time.OffsetDateTime;
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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "match_request")
public class MatchRequestEntity implements BaseEntity<MatchRequestDto> {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @Column(nullable = false)
    private Integer days;

    @Column(nullable = false)
    private Integer minTeamSize;

    @Column(nullable = true)
    private Integer maxTeamSize;

    @ManyToOne
    @JoinColumn(name = "event")
    private EventEntity event;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;

    @Override
    public MatchRequestDto toDto() {
        return MatchRequestDto
            .builder()
            .id(id)
            .createdAt(createdAt)
            .days(days)
            .minTeamSize(minTeamSize)
            .maxTeamSize(Optional.ofNullable(maxTeamSize))
            .build();
    }
}
