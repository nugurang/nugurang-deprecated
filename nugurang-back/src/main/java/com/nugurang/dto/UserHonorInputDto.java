package com.nugurang.dto;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserHonorInputDto {
    @NotNull
    private Long user;
    @NotNull
    private List<PositionHonorInputDto> honors;
}
