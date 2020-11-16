package com.nugurang.entity;

import com.nugurang.dto.ArticleDto;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@NoArgsConstructor
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "article")
public class ArticleEntity implements BaseEntity<ArticleDto> {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Long viewCount;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime modifiedAt;

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
    public ArticleEntity(
        String title,
        String content,
        ThreadEntity thread,
        UserEntity user,
        ArticleEntity parent
    ) {
        this.title = title;
        this.content = content;
        this.viewCount = Long.valueOf(0);
        this.thread = thread;
        this.user = user;
        this.parent = parent;
    }

    @Override
    public ArticleDto toDto() {
        return ArticleDto
            .builder()
            .id(id)
            .title(title)
            .content(content)
            .viewCount(viewCount)
            .createdAt(getCreatedAt())
            .modifiedAt(getModifiedAt())
            .build();
    }
}
