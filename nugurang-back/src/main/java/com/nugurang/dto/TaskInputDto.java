package com.nugurang.dto;

import java.util.List;
import java.util.Optional;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskInputDto {
    @NotNull
    private String name;
    @NotNull
    private Optional<Integer> difficulty;
    @NotNull
    private Optional<Integer> order;
    @NotNull
    private Optional<Long> progress;
    @NotNull
    private List<Long> users;
    @NotNull
    private List<Long> positions;
}
