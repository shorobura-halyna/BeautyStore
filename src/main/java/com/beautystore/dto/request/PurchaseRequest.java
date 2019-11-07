package com.beautystore.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Getter
@Setter
public class PurchaseRequest {
    private int id;
    @Positive
    private int totalAmount;
    private String date;
    private String nameCommodity;
}
