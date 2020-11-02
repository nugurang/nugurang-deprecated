package com.nugurang.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserHonorDto {
    @NotNull
    private Long id;
    @NotNull
    private Integer honor;
}
