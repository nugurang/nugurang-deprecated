package com.nugurang.entity;

import com.nugurang.dto.ImageDto;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "image")
public class ImageEntity implements BaseEntity<ImageDto>, Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false) 
    private String address;

    @OneToMany(mappedBy = "image")
    private List<EventEntity> events = new ArrayList<>();

    @OneToMany(mappedBy = "image")
    private List<UserEntity> users = new ArrayList<>();

    @OneToMany(mappedBy = "image", cascade = CascadeType.ALL)
    private List<XrefArticleImageEntity> xrefArticles = new ArrayList<>();

    @Builder
    public ImageEntity(String address) {
        this.address = address;
    }

    @PreRemove
    public void nullify() {
        this.events.forEach(event -> event.setImage(null));
        this.users.forEach(user -> user.setImage(null));
    }

    public ImageDto toDto() {
        return ImageDto
            .builder()
            .id(id)
            .address(address)
            .build();
    }
}
