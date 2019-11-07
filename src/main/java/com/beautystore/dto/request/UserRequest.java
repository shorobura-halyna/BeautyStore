package com.beautystore.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class UserRequest {
    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String secondName;
    @Size(min = 10)
    @NotBlank
    private String phone;
    @Email(message = "test not valid")
    @NotBlank
    private String email;
    @Positive
    @Max(value = 100)
    private int age;
    @JsonIgnoreProperties
    private String login;
    @Size(min = 5)
    @JsonIgnoreProperties
    private String password;
}
