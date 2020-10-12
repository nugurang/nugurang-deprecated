package com.nugurang.entity;

import java.io.Serializable;
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
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "article")
public class ArticleEntity extends DateAudit implements Serializable {
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
    private ThreadEntity thread;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "parent")
    private ArticleEntity parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<ArticleEntity> children = new ArrayList<>();

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<NotificationEntity> notifications = new ArrayList<>();

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<StarEntity> stars = new ArrayList<>();

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<XrefArticleImageEntity> xrefImages = new ArrayList<>();

    @Builder
    public ArticleEntity(String title, String content, ThreadEntity thread, UserEntity user) {
        this.title = title;
        this.content = content;
        this.viewCount = Long.valueOf(0);
        this.thread = thread;
        this.user = user;
    }
}
