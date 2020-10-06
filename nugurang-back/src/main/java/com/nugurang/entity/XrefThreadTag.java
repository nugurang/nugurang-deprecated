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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"thread", "tag"})
})
public class XrefThreadTag implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "thread", nullable = false)
    private Thread thread;

    @ManyToOne
    @JoinColumn(name = "tag", nullable = false)
    private Tag tag;

    @Builder
    public XrefThreadTag(Thread thread, Tag tag) {
        this.thread = thread;
        this.tag = tag;
    }
}
