package com.nugurang.entity;

import com.nugurang.dto.BoardDto;
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
@Table(name = "board")
public class BoardEntity implements BaseEntity<BoardDto> {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<XrefUserBoardEntity> xrefUsers = new ArrayList<>();

    @Builder
    public BoardEntity(String name) {
        this.name = name;
    }

    @Override
    public BoardDto toDto() {
        return BoardDto
            .builder()
            .id(id)
            .name(name)
            .build();
    }
}
