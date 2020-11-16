package com.nugurang.dto;

import java.util.Optional;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ThreadInputDto {
    @NotNull
    private String name;
    @NotNull
    private ArticleInputDto firstArticle;
    @NotNull
    private Long board;
    @NotNull
    private Optional<Long> event;
    @NotNull
    private Optional<Long> team;
}
