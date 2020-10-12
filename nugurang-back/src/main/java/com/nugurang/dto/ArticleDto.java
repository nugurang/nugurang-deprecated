package com.nugurang.dto;

import java.time.LocalDateTime;
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
    private String title;
    @NotNull
    private String content;
    @NotNull
    private Long viewCount;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private LocalDateTime modifiedAt;
    //thread
    //user
    //parent
    //children
    //notifications
    //stars
}
