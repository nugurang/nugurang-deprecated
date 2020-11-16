package com.nugurang.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkDto {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Integer order;
    @NotNull
    private Boolean opened;
}
