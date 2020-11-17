package com.nugurang.dto;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TeamInputDto {
    @NotNull
    private String name;
    @NotNull
    List<Long> users;
}
