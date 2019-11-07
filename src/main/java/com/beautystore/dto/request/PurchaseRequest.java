package com.beautystore.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PurchaseRequest {
    private int id;
    @Positive
    private int totalAmount;
    private String date;
}
