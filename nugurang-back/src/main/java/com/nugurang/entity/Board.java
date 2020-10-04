package com.nugurang.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Board implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToOne(mappedBy = "blog")
    private User user;

    @OneToMany(mappedBy = "board", cascade = CascadeType.PERSIST, CascadeType.REMOVE)
    private List<Thread> threads = new ArrayList<>();

    public Board(String name) {
        this.name = name;
    }

    public Board(User user, String name) {
        this(name);
        this.user = user;
    }

    @PreRemove
    public void nullify() {
        user.setBlog(null);
    }
}
