package com.nugurang.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    name = "xref_event_tag",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"event", "tag"})
    }
)
public class XrefEventTagEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event", nullable = false)
    private EventEntity event;

    @ManyToOne
    @JoinColumn(name = "tag", nullable = false)
    private TagEntity tag;

    @Builder
    public XrefEventTagEntity(EventEntity event, TagEntity tag) {
        this.event = event;
        this.tag = tag;
    }
}
