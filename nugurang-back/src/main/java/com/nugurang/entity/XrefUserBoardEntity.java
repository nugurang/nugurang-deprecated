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
    name = "xref_user_board",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user", "board"})
    }
)
public class XrefUserBoardEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "board", nullable = false)
    private BoardEntity board;

    @ManyToOne
    @JoinColumn(name = "role", nullable = false)
    private RoleEntity role;

    @Builder
    public XrefUserBoardEntity(UserEntity user, BoardEntity board, RoleEntity role) {
        this.user = user;
        this.board = board;
        this.role = role;
    }
}
