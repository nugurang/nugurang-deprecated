package com.nugurang.dto;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserReviewInputDto {
    @NotNull
    private Long toUser;
    @NotNull
    private List<PositionHonorInputDto> honors;
}
