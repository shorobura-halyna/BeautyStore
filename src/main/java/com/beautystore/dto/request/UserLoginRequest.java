package com.beautystore.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserLoginRequest {
    @NotBlank
    @NotNull
    private String login;
    @NotBlank
    @NotNull
    private String password;
}
