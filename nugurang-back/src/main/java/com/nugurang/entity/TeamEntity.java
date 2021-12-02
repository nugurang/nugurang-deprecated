package com.nugurang.entity;

import com.nugurang.dto.TeamDto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "team")
public class TeamEntity implements BaseEntity<TeamDto> {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<ProjectEntity> projects = new ArrayList<>();

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<XrefUserTeamEntity> xrefUsers = new ArrayList<>();

    @Builder
    public TeamEntity(String name) {
        this.name = name;
    }

    @Override
    public TeamDto toDto() {
        return TeamDto
            .builder()
            .id(id)
            .name(name)
            .build();
    }
}
