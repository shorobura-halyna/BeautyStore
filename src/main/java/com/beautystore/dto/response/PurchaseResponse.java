package com.beautystore.dto.response;

import com.beautystore.model.Purchase;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class PurchaseResponse {
    private int id;
    private int totalAmount;
    private LocalDateTime date;
    private List<CommodityResponse> commodityResponses = new ArrayList<>();

    public PurchaseResponse(Purchase purchase) {
        this.id = purchase.getId();
        this.totalAmount = purchase.getTotalAmount();
        this.date = purchase.getDate();
        this.commodityResponses = purchase.getCommodities().stream()
                .map(CommodityResponse::new)
                .collect(Collectors.toList());
    }
}
