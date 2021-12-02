package com.nugurang.entity;

import com.nugurang.dto.ImageDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Setter
@Entity
@Table(name = "image")
public class ImageEntity implements BaseEntity<ImageDto> {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false) 
    private String address;

    public ImageDto toDto() {
        return ImageDto
            .builder()
            .id(id)
            .address(address)
            .build();
    }
}
