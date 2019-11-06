package com.beautystore.dto.response;

import com.beautystore.model.Brand;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class BrandResponse {
    private int id;
    private String name;
    private List<CommodityResponse> commoditiesResponse;

    public BrandResponse(Brand brand) {
        this.id = brand.getId();
        this.name = brand.getName();
        this.commoditiesResponse = brand.getCommodities().stream()
                .map(CommodityResponse::new)
                .collect(Collectors.toList());
    }
}
