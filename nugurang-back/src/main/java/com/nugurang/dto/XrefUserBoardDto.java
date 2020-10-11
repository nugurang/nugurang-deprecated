package com.nugurang.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class XrefUserBoardDto {
    @NotNull
    private Long id;
    //role
    //user
    //board
}
