package com.nugurang.entity;

import com.nugurang.dto.UserDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Setter
@Table(
    name = "user",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"oauth2_provider", "oauth2_id"}),
    }
)
public class UserEntity implements BaseEntity<UserDto> {
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

    @OneToOne
    @JoinColumn(name = "blog")
    private BoardEntity blog;

    @ManyToOne
    @JoinColumn(name = "image")
    private ImageEntity image;

    @Override
    public UserDto toDto() {
        return UserDto
            .builder()
            .id(id)
            .oauth2Provider(oauth2Provider)
            .oauth2Id(oauth2Id)
            .email(email)
            .name(name)
            .biography(biography)
            .build();
    }
}
