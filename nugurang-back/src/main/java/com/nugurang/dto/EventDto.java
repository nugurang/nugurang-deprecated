package com.nugurang.dto;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class EventDto {
    @NotNull
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String content;
    @NotNull
    private LocalDateTime recruitingStart;
    @NotNull
    private LocalDateTime recruitingEnd;
    @NotNull
    private LocalDateTime eventStart;
    @NotNull
    private LocalDateTime eventEnd;
    //image
    //projects
    //threads
}
