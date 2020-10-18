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
    name = "user",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"oauth2_provider", "oauth2_id"}),
    }
)
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "oauth2_provider", nullable = false)
    private String oauth2Provider;

    @Column(name = "oauth2_id", nullable = false)
    private String oauth2Id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private String biography;

    @Column(nullable = false)
    byte[] password;

    @ManyToOne
    @JoinColumn(name = "image")
    private ImageEntity image;

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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<StarEntity> stars = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<XrefUserBoardEntity> xrefBoards = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<XrefUserPositionEntity> xrefPositions = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<XrefUserTaskEntity> xrefTasks = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<XrefUserTeamEntity> xrefTeams = new ArrayList<>();

    @Builder
    public UserEntity(
        String oauth2Provider,
        String oauth2Id,
        String name,
        String email,
        String password,
        ImageEntity image
    ) {
        this.oauth2Provider = oauth2Provider;
        this.oauth2Id = oauth2Id;
        this.name = name;
        this.email = email;
        this.password = new byte[60];
        this.image = image;
    }
}
