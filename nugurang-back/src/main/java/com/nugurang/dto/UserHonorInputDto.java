package com.nugurang.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserHonorInputDto {
    @NotNull
    private Integer honor;
    @NotNull
    private Long user;
    @NotNull
    private Long position;
}
