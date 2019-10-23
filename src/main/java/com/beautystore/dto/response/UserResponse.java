package com.beautystore.dto.response;

import com.beautystore.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserResponse {
    private String firstName;
    private String secondName;

    private List<PurchaseResponse> purchaseResponses = new ArrayList<>();

    public UserResponse(User user) {
        this.firstName = user.getFirstName();
        this.secondName = user.getSecondName();
        this.purchaseResponses = user.getPurchases().stream()
                .map(PurchaseResponse::new)
                .collect(Collectors.toList());
    }
}
