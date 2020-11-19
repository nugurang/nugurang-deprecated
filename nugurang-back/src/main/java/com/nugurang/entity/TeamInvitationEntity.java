package com.nugurang.entity;

import com.nugurang.dto.TeamInvitationDto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(
    name = "team_invitation",
    uniqueConstraints = @UniqueConstraint(columnNames = {"team", "user"})
)
public class TeamInvitationEntity implements BaseEntity<TeamInvitationDto> {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team")
    private TeamEntity team;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;

    @Override
    public TeamInvitationDto toDto() {
        return TeamInvitationDto
            .builder()
            .id(id)
            .build();
    }
}
