package com.nugurang.entity;

import com.nugurang.dto.EventDto;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "event")
public class EventEntity implements Serializable, BaseEntity<EventDto> {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime recruitingStart;

    @Column(nullable = false)
    private LocalDateTime recruitingEnd;
    
    @Column(nullable = false)
    private LocalDateTime eventStart;

    @Column(nullable = false)
    private LocalDateTime eventEnd;

    @Builder
    public EventEntity(
        String title, String content,
        LocalDateTime recruitingStart, LocalDateTime recruitingEnd,
        LocalDateTime eventStart, LocalDateTime eventEnd) {
        this.title = title;
        this.content = content;
        this.recruitingStart = recruitingStart;
        this.recruitingEnd = recruitingEnd;
        this.eventStart = eventStart;
        this.eventEnd = eventEnd;
    }

    public EventDto toDto() {
        return EventDto
            .builder()
            .title(title)
            .content(content)
            .recruitingStart(recruitingStart)
            .recruitingEnd(recruitingEnd)
            .eventStart(eventStart)
            .eventEnd(eventEnd)
            .build();
    }
}
