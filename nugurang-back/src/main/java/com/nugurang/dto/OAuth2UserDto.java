package com.nugurang.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class OAuth2UserDto {
    @NotNull
    private String provider;
    @NotNull
    private String id;
    @NotNull
    private String name;
    @NotNull
    private String email;
}
