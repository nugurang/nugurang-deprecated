package com.nugurang.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Thread implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "xref_user_team", nullable = false)
    private XrefUserTeam xrefUserTeam;

    @ManyToOne
    @JoinColumn(name = "board", nullable = false)
    private Board board;

    @ManyToOne
    @JoinColumn(name = "event")
    private Event event;

    @OneToMany(mappedBy = "thread", cascade = CascadeType.PERSIST, CascadeType.REMOVE)
    private List<Article> article = new ArrayList<Article>();

    public Thread(String name, User user, Board board) {
        this.name = name;
        this.user = user;
        this.board = board;
    }

    public Thread(String name, User user, Board board, Event event) {
        this(name, user, board);
        this.event = event;
    }
}
