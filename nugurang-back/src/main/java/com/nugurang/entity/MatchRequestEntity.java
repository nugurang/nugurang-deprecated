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
import javax.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Setter
@Entity
@Table(
    name = "match_request",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"event", "user"})
    }
)
public class MatchRequestEntity implements BaseEntity<MatchRequestDto> {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @Column(nullable = false)
    private OffsetDateTime expiredAt;

    @Column(nullable = false)
    private Integer minTeamSize;

    @Column(nullable = true)
    private Integer maxTeamSize;

    @ManyToOne
    @JoinColumn(name = "type")
    private MatchTypeEntity type;

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
            .expiredAt(expiredAt)
            .minTeamSize(minTeamSize)
            .maxTeamSize(Optional.ofNullable(maxTeamSize))
            .build();
    }
}
