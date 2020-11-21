package com.nugurang.entity;

import com.nugurang.dto.NotificationDto;
import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "notification")
public class NotificationEntity implements BaseEntity<NotificationDto> {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Boolean isRead;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "notification_type", nullable = false)
    private NotificationTypeEntity notificationType;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;

    public NotificationDto toDto() {
        return NotificationDto
            .builder()
            .id(id)
            .isRead(isRead)
            .createdAt(createdAt)
            .build();
    }
}
