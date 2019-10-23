package com.beautystore.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommodityResponse {
    private String name;
    private int price;

    public CommodityResponse(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
