package com.nugurang.entity;

import com.nugurang.dto.UserEvaluationDto;
import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "user_evaluation")
public class UserEvaluationEntity implements BaseEntity<UserEvaluationDto> {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @Column(nullable = false)
    private OffsetDateTime expiredAt;

    public UserEvaluationDto toDto() {
        return UserEvaluationDto
            .builder()
            .id(id)
            .createdAt(createdAt)
            .expiredAt(expiredAt)
            .build();
    }
}
