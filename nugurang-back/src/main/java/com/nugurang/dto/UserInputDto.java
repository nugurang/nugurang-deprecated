package com.nugurang.dto;

import java.util.Optional;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserInputDto {
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String biography;
    @NotNull
    private Optional<Long> image;
}
