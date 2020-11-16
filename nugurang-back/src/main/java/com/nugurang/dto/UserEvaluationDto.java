package com.nugurang.dto;

import java.time.OffsetDateTime;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEvaluationDto {
    @NotNull
    private Long id;
    @NotNull
    private OffsetDateTime startedAt;
    @NotNull
    private Integer days;
}
