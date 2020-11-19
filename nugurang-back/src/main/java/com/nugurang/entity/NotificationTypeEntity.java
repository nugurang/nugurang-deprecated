package com.nugurang.entity;

import com.nugurang.dto.NotificationTypeDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "vote_type")
public class NotificationTypeEntity implements BaseEntity<NotificationTypeDto> {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public NotificationTypeDto toDto() {
        return NotificationTypeDto
            .builder()
            .id(id)
            .name(name)
            .build();
    }
}
