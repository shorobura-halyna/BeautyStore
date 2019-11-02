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
    private String category;
    private String subcategory;

    public CommodityResponse(Commodity commodity) {
        this.name = commodity.getName();
        this.price = commodity.getPrice();
        this.brand = commodity.getBrand().getName();
        this.category = commodity.getSubcategory().getCategory().getName();
        this.subcategory = commodity.getSubcategory().getName();

    }
}
