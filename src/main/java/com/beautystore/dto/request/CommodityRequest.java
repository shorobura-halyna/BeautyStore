package com.beautystore.dto.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

public class CommodityRequest {
    @Max(240)
    private String name;
    @NotBlank
    private int price;
}
