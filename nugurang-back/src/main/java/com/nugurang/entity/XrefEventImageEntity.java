package com.nugurang.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Table(
    name = "xref_event_image",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"event", "image"})
    }
)
public class XrefEventImageEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event", nullable = false)
    private EventEntity event;

    @ManyToOne
    @JoinColumn(name = "image", nullable = false)
    private ImageEntity image;

    @Builder
    public XrefEventImageEntity(EventEntity event, ImageEntity image) {
        this.event = event;
        this.image = image;
    }
}
