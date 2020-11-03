package com.nugurang.entity;

import com.nugurang.dto.NotificationDto;
import java.io.Serializable;
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
import javax.persistence.UniqueConstraint;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@NoArgsConstructor
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(
    name = "notification",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user", "article"})
    }
)
public class NotificationEntity implements Serializable, BaseEntity<NotificationDto> {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    private String content;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "article")
    private ArticleEntity article;

    @Builder
    public NotificationEntity(UserEntity user, ArticleEntity article) {
        this.user = user;
        this.article = article;
    }

    public NotificationDto toDto() {
        return NotificationDto
            .builder()
            .id(id)
            .title(title)
            .content(Optional.ofNullable(content))
            .build();
    }
}
