package com.nugurang.dto;

import java.util.List;
import java.util.Optional;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ArticleInputDto {
    @NotNull
    private String content;
    @NotNull
    private Optional<String> title;
    @NotNull
    private List<Long> images;
}
