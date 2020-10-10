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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class UserEntity implements Serializable {
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
    private ImageEntity image;

    @OneToOne
    @JoinColumn(name = "blog", unique = true)
    private BoardEntity blog;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ThreadEntity> threads = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ArticleEntity> articles = new ArrayList<>();

    @OneToMany(mappedBy = "fromUser", cascade = CascadeType.ALL)
    private List<FollowingEntity> follwings = new ArrayList<>();

    @OneToMany(mappedBy = "toUser", cascade = CascadeType.ALL)
    private List<FollowingEntity> followers = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<NotificationEntity> notifications = new ArrayList<>();

    @Builder
    public UserEntity(
        String name, String email, String password, ImageEntity image, BoardEntity blog
    ) {
        this.name = name;
        this.email = email;
        this.password = new byte[60];
        this.image = image;
        this.blog = blog;
    }
}
