package com.nugurang.dto;

import java.time.OffsetDateTime;
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
public class EventInputDto {
    @NotNull
    private String name;
    @NotNull
    private String content;
    @NotNull
    private OffsetDateTime recruitingStart;
    @NotNull
    private OffsetDateTime recruitingEnd;
    @NotNull
    private OffsetDateTime eventStart;
    @NotNull
    private OffsetDateTime eventEnd;
    @NotNull
    private List<Long> images;
}
