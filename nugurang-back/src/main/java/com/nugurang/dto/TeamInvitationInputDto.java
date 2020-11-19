package com.nugurang.dto;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TeamInvitationInputDto {
    @NotNull
    private Long team;
    @NotNull
    private List<Long> users;
}
