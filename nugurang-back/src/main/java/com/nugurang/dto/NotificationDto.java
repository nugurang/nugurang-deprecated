package com.nugurang.dto;

import java.time.OffsetDateTime;
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
    private Boolean isRead;
    @NotNull
    private OffsetDateTime createdAt;
}
