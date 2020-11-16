package com.nugurang.dto;

import java.time.OffsetDateTime;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ThreadDto {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private OffsetDateTime createdAt;
    @NotNull
    private OffsetDateTime modifiedAt;
}
