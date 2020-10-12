package com.nugurang.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(
    name = "notification",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user", "article"})
    }
)

public class NotificationEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    private String content;

    @Column(nullable = false)
    private LocalDateTime at;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "article")
    private ArticleEntity article;

    @Builder
    public NotificationEntity(UserEntity user, ArticleEntity article) {
        this.at = LocalDateTime.now();
        this.user = user;
        this.article = article;
    }
}
