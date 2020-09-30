package com.nugurang.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"event", "tag"})
})
public class XrefEventTag implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event", nullable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "tag", nullable = false)
    private Tag tag;

    public XrefEventTag(Event event, Tag tag) {
        this.event = event;
        this.tag = tag;
    }
}
