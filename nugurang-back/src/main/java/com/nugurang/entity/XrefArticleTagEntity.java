package com.nugurang.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Setter
@Table(
    name = "xref_article_tag",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"article", "tag"})
    }
)
public class XrefArticleTagEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "article", nullable = false)
    private ArticleEntity article;

    @ManyToOne
    @JoinColumn(name = "tag", nullable = false)
    private TagEntity tag;
}
