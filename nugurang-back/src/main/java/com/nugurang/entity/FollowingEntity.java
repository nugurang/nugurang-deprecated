package com.nugurang.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
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

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(
    name = "following",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"from_user", "to_user"})
    }
)
public class FollowingEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_user", nullable = false)
    private UserEntity fromUser;

    @ManyToOne
    @JoinColumn(name = "to_user", nullable = false)
    private UserEntity toUser;

    @Builder
    public FollowingEntity(UserEntity fromUserEntity, UserEntity toUserEntity) {
        this.fromUser = fromUser;
        this.toUser = toUser;
    }
}
