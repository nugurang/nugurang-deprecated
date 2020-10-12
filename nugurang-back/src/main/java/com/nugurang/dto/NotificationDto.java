package com.nugurang.dto;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class NotificationDto {
    @NotNull
    private Long id;
    @NotNull
    private String title;
    private String content;
    @NotNull
    private LocalDateTime at;
    // user
    // article
}
