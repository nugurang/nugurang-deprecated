package com.nugurang.dto;

import java.util.Optional;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TaskInputDto {
    @NotNull
    private String name;
    @NotNull
    private Optional<Integer> difficulty;
    @NotNull
    private Optional<Integer> order;
    @NotNull
    private Long work;
    @NotNull
    private Optional<Long> progress;
}
