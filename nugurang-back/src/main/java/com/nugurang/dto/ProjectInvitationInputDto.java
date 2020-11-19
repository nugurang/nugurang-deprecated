package com.nugurang.dto;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ProjectInvitationInputDto {
    @NotNull
    private Long project;
    @NotNull
    private List<Long> users;
}
