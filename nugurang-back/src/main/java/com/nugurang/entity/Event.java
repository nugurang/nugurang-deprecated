package com.nugurang.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Event implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Board board;

    @ManyToOne
    @JoinColumn(name = "image")
    private Image image;

    @Column(nullable = false)
    private String title;

    @Column
    private String content;

    @Column(nullable = false)
    private LocalDateTime recruitingStart;

    @Column(nullable = false)
    private LocalDateTime recruitingEnd;
    
    @Column(nullable = false)
    private LocalDateTime eventStart;

    @Column(nullable = false)
    private LocalDateTime eventEnd;
}
