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
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Event implements Serializable {
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
    @OnDelete(action=OnDeleteAction.CASCADE)
    private Image image;

    @OneToMany(mappedBy = "event")
    private List<Project> projects = new ArrayList<>();

    @OneToMany(mappedBy = "event")
    private List<Thread> threads = new ArrayList<>();

    public Event(
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
        projects.forEach(project -> project.setEvent(null));
        threads.forEach(thread -> thread.setEvent(null));
    }
}
