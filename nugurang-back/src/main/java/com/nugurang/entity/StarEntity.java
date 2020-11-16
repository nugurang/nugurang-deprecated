package com.nugurang.entity;

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
    name = "star",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user", "article"})
    }
)
public class StarEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "article", nullable = false)
    private ArticleEntity article;

    @Builder
    public StarEntity(UserEntity user, ArticleEntity article) {
        this.user = user;
        this.article = article;
    }
}
