package com.nugurang.dto;

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
    //thread
    //user
    //parent
    //children
    //notifications
    //stars
}
