package com.nugurang.dto;

import java.util.Optional;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PositionInputDto {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Optional<String> description;
    @NotNull
    private Optional<Long> image;
}
