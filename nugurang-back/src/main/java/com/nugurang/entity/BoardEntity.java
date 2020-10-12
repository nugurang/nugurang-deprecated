package com.nugurang.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "board")
public class BoardEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToOne(mappedBy = "blog")
    private UserEntity user;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<ThreadEntity> threads = new ArrayList<>();

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<XrefUserBoardEntity> xrefUsers = new ArrayList<>();

    @Builder
    public BoardEntity(String name, UserEntity user) {
        this.name = name;
        this.user = user;
    }

    @PreRemove
    public void nullify() {
        this.user.setBlog(null);
    }
}
