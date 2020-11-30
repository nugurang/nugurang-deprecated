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
public class MatchRequestInputDto {
    @NotNull
    private OffsetDateTime createdAt;
    @NotNull
    private Optional<Integer> days;
    @NotNull
    private Optional<Integer> hours;
    @NotNull
    private Optional<Integer> minutes;
    @NotNull
    private Integer minTeamSize;
    @NotNull
    private Optional<Integer> maxTeamSize;
    @NotNull
    private Long type;
    @NotNull
    private Long event;
}
