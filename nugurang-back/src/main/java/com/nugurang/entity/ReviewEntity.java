package com.nugurang.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(
    name = "review",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"reviewer", "user_honor", "evaluation"})
    }
)
public class ReviewEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reviewer", nullable = false)
    private UserEntity reviewer;

    @ManyToOne
    @JoinColumn(name = "user_honor", nullable = false)
    private UserHonorEntity userHonor;

    @ManyToOne
    @JoinColumn(name = "evaluation", nullable = false)
    private EvaluationEntity evaluation;
}
