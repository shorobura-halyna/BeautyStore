package com.beautystore.dto.response;

import com.beautystore.model.Basket;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class BasketResponse {
    private int id;
    private int amount;
    private List<CommodityResponse> commodities;

    public BasketResponse(Basket basket) {
        this.amount = basket.getAmount();
        this.id = basket.getId();
        this.commodities = basket.getCommodities().stream()
                .map(CommodityResponse::new)
                .collect(Collectors.toList());
    }
}

