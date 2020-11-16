package com.nugurang.dto;

import java.util.Optional;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ProjectInputDto {
    @NotNull
    private String name;
    @NotNull
    private Long team;
    @NotNull
    private Optional<Long> event;
}
