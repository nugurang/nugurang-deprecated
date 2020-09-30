package com.nugurang.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Article extends DateAudit implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Long viewCount;

    @ManyToOne
    @JoinColumn(name = "thread", nullable = false)
    private Thread thread;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "parent")
    private Article parent;

    @OneToMany(mappedBy = "parent")
    private List<Article> children = new ArrayList<>();

    @OneToMany(mappedBy = "article")
    private List<Notification> notifiactions = new ArrayList<>();

    @OneToMany(mappedBy = "article")
    private List<Star> stars = new ArrayList<>();

    public Article(String title, String content, Thread thread, User user) {
        this.title = title;
        this.content = content;
        this.viewCount = Long.valueOf(0);
        this.thread = thread;
        this.user = user;
    }
}
