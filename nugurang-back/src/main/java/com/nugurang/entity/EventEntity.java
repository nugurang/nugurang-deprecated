package com.nugurang.entity;

import com.nugurang.dto.EventDto;
import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name = "event")
public class EventEntity implements BaseEntity<EventDto> {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private OffsetDateTime recruitingStart;

    @Column(nullable = false)
    private OffsetDateTime recruitingEnd;
    
    @Column(nullable = false)
    private OffsetDateTime eventStart;

    @Column(nullable = false)
    private OffsetDateTime eventEnd;

    public EventDto toDto() {
        return EventDto
            .builder()
            .id(id)
            .name(name)
            .description(description)
            .recruitingStart(recruitingStart)
            .recruitingEnd(recruitingEnd)
            .eventStart(eventStart)
            .eventEnd(eventEnd)
            .build();
    }
}
