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

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(
    name = "xref_user_board",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user", "board"})
    }
)
public class XrefUserBoardEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "role", nullable = false)
    private RoleEntity role;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "board", nullable = false)
    private BoardEntity board;

    @Builder
    public XrefUserBoardEntity(RoleEntity role, UserEntity user, BoardEntity board) {
        this.role = role;
        this.user = user;
        this.board = board;
    }
}
