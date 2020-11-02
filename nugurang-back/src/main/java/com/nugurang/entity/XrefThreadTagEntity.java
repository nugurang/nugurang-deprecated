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
    name = "xref_thread_tag",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"thread", "tag"})
    }
)
public class XrefThreadTagEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "thread", nullable = false)
    private ThreadEntity thread;

    @ManyToOne
    @JoinColumn(name = "tag", nullable = false)
    private TagEntity tag;

    @Builder
    public XrefThreadTagEntity(ThreadEntity thread, TagEntity tag) {
        this.thread = thread;
        this.tag = tag;
    }
}
