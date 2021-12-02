package com.nugurang.entity;

import com.nugurang.dto.UserReviewDto;
import javax.persistence.Column;
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
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(
    name = "user_review",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "position", "from_user", "to_user", "user_evaluation"
        })
    }
)
public class UserReviewEntity implements BaseEntity<UserReviewDto> {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer honor;

    @ManyToOne
    @JoinColumn(name = "position", nullable = false)
    private PositionEntity position;

    @ManyToOne
    @JoinColumn(name = "from_user", nullable = false)
    private UserEntity fromUser;

    @ManyToOne
    @JoinColumn(name = "to_user", nullable = false)
    private UserEntity toUser;

    @ManyToOne
    @JoinColumn(name = "user_evaluation", nullable = false)
    private UserEvaluationEntity userEvaluation;

    public UserReviewDto toDto() {
        return UserReviewDto
            .builder()
            .id(id)
            .honor(honor)
            .build();
    }
}
