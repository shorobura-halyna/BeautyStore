package com.beautystore.dto.response;

import com.beautystore.model.Commodity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommodityResponse {
    private String name;
    private int price;
    private String brand;

    public CommodityResponse(Commodity commodity) {
        this.name = commodity.getName();
        this.price = commodity.getPrice();
        this.brand = commodity.getBrand().getName();
    }
}
