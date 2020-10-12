package com.nugurang.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "position")
public class PositionEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
    private List<XrefTaskPositionEntity> xrefTasks = new ArrayList<>();

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
    private List<XrefUserPositionEntity> xrefUsers = new ArrayList<>();

    @Builder
    public PositionEntity(String name) {
        this.name = name;
    }
}
