package com.beautystore.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BasketResponse {
    private int amount;
    private List<CommodityResponse> commodities = new ArrayList<>();
}

