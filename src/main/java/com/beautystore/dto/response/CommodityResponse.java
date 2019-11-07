package com.beautystore.dto.response;

import com.beautystore.model.Commodity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommodityResponse {
    private int id;
    private String name;
    private int price;
    private String brand;
    private String subcategory;

    public CommodityResponse(Commodity commodity) {
        this.id = commodity.getId();
        this.name = commodity.getName();
        this.price = commodity.getPrice();
        this.brand = commodity.getBrand().getName();
        this.subcategory = commodity.getSubcategory() != null ? commodity.getSubcategory().getName() : "";
    }
}
