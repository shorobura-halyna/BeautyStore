package com.beautystore.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SubcategoryRequest {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String categoryName;
}
