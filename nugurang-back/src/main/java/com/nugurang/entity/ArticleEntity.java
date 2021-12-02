package com.nugurang.entity;

import com.nugurang.dto.ArticleDto;
import java.time.OffsetDateTime;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
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

    @Override
    public ArticleDto toDto() {
        return ArticleDto
            .builder()
            .id(id)
            .title(Optional.ofNullable(title))
            .content(content)
            .createdAt(getCreatedAt())
            .modifiedAt(getModifiedAt())
            .build();
    }
}
