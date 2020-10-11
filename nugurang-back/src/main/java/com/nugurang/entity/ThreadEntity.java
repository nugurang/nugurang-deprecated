package com.nugurang.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "thread")
public class ThreadEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "xref_user_team", nullable = false)
    private XrefUserTeamEntity xrefUserTeam;

    @ManyToOne
    @JoinColumn(name = "board", nullable = false)
    private BoardEntity board;

    @ManyToOne
    @JoinColumn(name = "event")
    private EventEntity event;

    @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL)
    private List<ArticleEntity> article = new ArrayList<ArticleEntity>();

    @Builder
    public ThreadEntity(String name, UserEntity user, BoardEntity board, EventEntity event) {
        this.name = name;
        this.user = user;
        this.board = board;
        this.event = event;
    }
}
