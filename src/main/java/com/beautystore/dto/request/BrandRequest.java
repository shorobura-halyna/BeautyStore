package com.beautystore.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class BrandRequest {
    private int id;
    @NotNull
    @NotBlank
    private String name;
}
