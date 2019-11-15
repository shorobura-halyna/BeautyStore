package com.beautystore.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserRequest {
    @Email(message = "email not valid")
    @NotBlank
    private String email;
    private String login;
    private String password;
}
