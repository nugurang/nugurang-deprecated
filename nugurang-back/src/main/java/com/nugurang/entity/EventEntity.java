package com.nugurang.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
public class EventEntity implements Serializable {
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

    @ManyToOne
    @JoinColumn(name = "image")
    private ImageEntity image;

    @OneToMany(mappedBy = "event")
    private List<ProjectEntity> projects = new ArrayList<>();

    @OneToMany(mappedBy = "event")
    private List<ThreadEntity> threads = new ArrayList<>();

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<XrefEventTagEntity> xrefTags = new ArrayList<>();

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

    @PreRemove
    public void nullify() {
        this.projects.forEach(project -> project.setEvent(null));
        this.threads.forEach(thread -> thread.setEvent(null));
    }
}
