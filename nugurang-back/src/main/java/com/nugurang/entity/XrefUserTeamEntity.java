package com.nugurang.entity;

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
    name = "xref_user_team",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user", "team"})
    }
)
public class XrefUserTeamEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "team", nullable = false)
    private TeamEntity team;

    @ManyToOne
    @JoinColumn(name = "role", nullable = false)
    private RoleEntity role;

    @Builder
    public XrefUserTeamEntity(UserEntity user, TeamEntity team, RoleEntity role) {
        this.user = user;
        this.team = team;
        this.role = role;
    }
}
