package com.nugurang.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
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
    //blog
    //threads
    //articles
    //followings
    //followers
    //notifications
}
