package com.nugurang.entity;

import com.nugurang.dto.ThreadDto;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@NoArgsConstructor
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "thread")
public class ThreadEntity implements BaseEntity<ThreadDto>, Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime modifiedAt;

    @ManyToOne
    @JoinColumn(name = "board", nullable = false)
    private BoardEntity board;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "xref_user_team")
    private XrefUserTeamEntity xrefUserTeam;

    @ManyToOne
    @JoinColumn(name = "event")
    private EventEntity event;

    @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL)
    private List<XrefThreadTagEntity> xrefTags = new ArrayList<>();

    @Builder
    public ThreadEntity(
        String name,
        BoardEntity board,
        UserEntity user,
        XrefUserTeamEntity xrefUserTeam,
        EventEntity event) {
        this.name = name;
        this.board = board;
        this.user = user;
        this.xrefUserTeam = xrefUserTeam;
        this.event = event;
    }

    @Override
    public ThreadDto toDto() {
        return ThreadDto
            .builder()
            .id(id)
            .name(name)
            .createdAt(createdAt)
            .modifiedAt(modifiedAt)
            .build();
    }
}
