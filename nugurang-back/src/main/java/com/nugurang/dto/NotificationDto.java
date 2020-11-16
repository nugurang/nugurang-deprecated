package com.nugurang.dto;

import java.time.OffsetDateTime;
import java.util.Optional;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationDto {
    @NotNull
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private Optional<String> content;
    @NotNull
    private OffsetDateTime createdAt;
}
