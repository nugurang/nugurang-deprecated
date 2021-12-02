package com.nugurang.entity;

import com.nugurang.dto.TeamInvitationDto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Setter
@Entity
@Table(
    name = "team_invitation",
    uniqueConstraints = @UniqueConstraint(columnNames = {"team", "from_user", "to_user"})
)
public class TeamInvitationEntity implements BaseEntity<TeamInvitationDto> {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "status")
    private InvitationStatusEntity status;

    @ManyToOne
    @JoinColumn(name = "team")
    private TeamEntity team;

    @ManyToOne
    @JoinColumn(name = "from_user")
    private UserEntity fromUser;

    @ManyToOne
    @JoinColumn(name = "to_user")
    private UserEntity toUser;

    @Override
    public TeamInvitationDto toDto() {
        return TeamInvitationDto
            .builder()
            .id(id)
            .build();
    }
}
