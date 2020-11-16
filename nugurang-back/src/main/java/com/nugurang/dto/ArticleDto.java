package com.nugurang.dto;

import java.time.OffsetDateTime;
import java.util.Optional;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ArticleDto {
    @NotNull
    private Long id;
    @NotNull
    private Optional<String> title;
    @NotNull
    private String content;
    @NotNull
    private Long viewCount;
    @NotNull
    private OffsetDateTime createdAt;
    @NotNull
    private OffsetDateTime modifiedAt;
}
