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
public class UserDto {
    @NotNull
    private Long id;
    @NotNull
    private String oauth2Provider;
    @NotNull
    private String oauth2Id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    private String biography;
}
