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
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    byte[] password;

    @ManyToOne
    @JoinColumn(name = "image")
    private Image image;

    @OneToOne
    @JoinColumn(name = "blog", unique = true)
    private Board blog;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, CascadeType.REMOVE)
    private List<Thread> threads = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, CascadeType.REMOVE)
    private List<Article> articles = new ArrayList<>();

    @OneToMany(mappedBy = "fromUser", cascade = CascadeType.PERSIST, CascadeType.REMOVE)
    private List<Following> follwings = new ArrayList<>();

    @OneToMany(mappedBy = "toUser", cascade = CascadeType.PERSIST, CascadeType.REMOVE)
    private List<Following> followers = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, CascadeType.REMOVE)
    private List<Notification> notifications = new ArrayList<>();

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = new byte[60];
    }

    public User(String name, String email, String password, Image image) {
        this(name, email, password);
        this.image = image;
    }

    public User(String name, String email, String password, Board blog) {
        this(name, email, password);
        this.blog = blog;
    }

    public User(String name, String email, String password, Image image, Board blog) {
        this(name, email, password, image);
        this.blog = blog;
    }
}
