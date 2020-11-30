package com.nugurang.dto;

import java.time.OffsetDateTime;
import java.util.Optional;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MatchRequestDto {
    @NotNull
    private Long id;
    @NotNull
    private OffsetDateTime createdAt;
    @NotNull
    private OffsetDateTime expiredAt;
    @NotNull
    private Integer minTeamSize;
    @NotNull
    private Optional<Integer> maxTeamSize;
}
