package com.beautystore.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SubcategoryRequest {
    private int id;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    private int categoryId;
}
