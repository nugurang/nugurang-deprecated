package com.nugurang.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Table(
    name = "xref_article_image",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"article", "image"})
    }
)
public class XrefArticleImageEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "article", nullable = false)
    private ArticleEntity article;

    @ManyToOne
    @JoinColumn(name = "image", nullable = false)
    private ImageEntity image;

    @Builder
    public XrefArticleImageEntity(ArticleEntity article, ImageEntity image) {
        this.article = article;
        this.image = image;
    }
}
