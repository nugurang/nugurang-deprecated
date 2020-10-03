package com.nugurang.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Image implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false) 
    private String address;

    @OneToMany(mappedBy = "image")
    private List<Event> events = new ArrayList<>();

    @OneToMany(mappedBy = "image")
    private List<User> users = new ArrayList<>();

    public Image(String address) {
        this.address = address;
    }

    @PreRemove
    public void nullify() {
        events.forEach(event -> event.setImage(null));
        users.forEach(user -> user.setImage(null));
    }
}
