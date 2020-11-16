package com.nugurang.entity;

import com.nugurang.dto.VoteDto;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(
    name = "vote",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user", "article"})
    }
)
public class VoteEntity implements BaseEntity<VoteDto> {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "article", nullable = false)
    private ArticleEntity article;

    @ManyToOne
    @JoinColumn(name = "vote_type", nullable = false)
    private VoteTypeEntity voteType;

    public VoteDto toDto() {
        return VoteDto
            .builder()
            .id(id)
            .build();
    }
}
