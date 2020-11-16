package com.nugurang.entity;

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
@Table(name = "tag")
public class TagEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL)
    private List<XrefEventTagEntity> xrefEvents = new ArrayList<>();

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL)
    private List<XrefThreadTagEntity> xrefThreads = new ArrayList<>();

    @Builder
    public TagEntity(String name) {
        this.name = name;
    }
}
