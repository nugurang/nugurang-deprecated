package com.nugurang.entity;

import com.nugurang.dto.ImageDto;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    @Builder
    public ImageEntity(String address) {
        this.address = address;
    }

    public ImageDto toDto() {
        return ImageDto
            .builder()
            .id(id)
            .address(address)
            .build();
    }
}
