package com.nugurang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "notification_data")
public class NotificationDataEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String value;

    @ManyToOne
    @JoinColumn(name = "notification", nullable = false)
    private NotificationEntity notification;
}
