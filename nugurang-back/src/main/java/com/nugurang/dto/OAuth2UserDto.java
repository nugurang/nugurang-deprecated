package com.nugurang.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OAuth2UserDto {
    @NotNull
    private String id;
    @NotNull
    private String provider;
    @NotNull
    private String name;
    @NotNull
    private String email;
}
