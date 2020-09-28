package com.nugurang.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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

    //UserTeam userTeam;

    @ManyToOne
    @JoinColumn(name = "board", nullable = false)
    private Board board;

    @ManyToOne
    @JoinColumn(name = "event")
    private Event event;

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
