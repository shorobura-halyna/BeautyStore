package com.beautystore.dto.response;

import com.beautystore.model.Purchase;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PurchaseResponse {
    private int id;
    private int totalAmount;
    private LocalDate date;

    public PurchaseResponse(Purchase purchase) {
        this.id = purchase.getId();
        this.totalAmount = purchase.getTotalAmount();
        this.date = purchase.getDate();
    }

}
