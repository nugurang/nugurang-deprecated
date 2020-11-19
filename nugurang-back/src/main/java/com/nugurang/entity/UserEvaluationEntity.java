package com.nugurang.entity;

import com.nugurang.dto.UserEvaluationDto;
import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user_evaluation")
public class UserEvaluationEntity implements BaseEntity<UserEvaluationDto> {
    @Id
    @GeneratedValue
    private Long id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime startedAt;

    @Column(nullable = false)
    private Integer days;

    public UserEvaluationDto toDto() {
        return UserEvaluationDto
            .builder()
            .id(id)
            .startedAt(startedAt)
            .days(days)
            .build();
    }
}
