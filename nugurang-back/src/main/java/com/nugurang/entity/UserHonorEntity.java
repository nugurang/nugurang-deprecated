package com.nugurang.entity;

import com.nugurang.dto.UserHonorDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Table(
    name = "user_honor",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user", "position"})
    }
)
public class UserHonorEntity implements BaseEntity<UserHonorDto> {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer honor;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "position", nullable = false)
    private PositionEntity position;

    @Builder
    public UserHonorEntity(Integer honor, UserEntity user, PositionEntity position) {
        this.honor = honor;
        this.user = user;
        this.position = position;
    }

    public UserHonorDto toDto() {
        return UserHonorDto
            .builder()
            .id(id)
            .honor(honor)
            .build();
    }
}
