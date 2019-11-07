package com.beautystore.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class CommodityRequest {
    private int id;
    @NotNull
    @NotBlank
    private String name;
    @Positive
    private int price;
    private int brandId;
    private int subcategoryId;

}
