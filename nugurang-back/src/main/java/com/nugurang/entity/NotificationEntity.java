package com.nugurang.entity;

import com.nugurang.dto.NotificationDto;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@TypeDefs({
    @TypeDef(
            name = "string-array",
            typeClass = StringArrayType.class
    )
})
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

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "notification_type", nullable = false)
    private NotificationTypeEntity notificationType;

    @Type(type = "string-array")
    @Column(
        name = "data",
        columnDefinition = "text[]"
    )
    private String[] data;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;

    public NotificationDto toDto() {
        return NotificationDto
            .builder()
            .id(id)
            .createdAt(createdAt)
            .data(data)
            .build();
    }
}
