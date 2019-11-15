package com.beautystore.dto.response;

import com.beautystore.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserResponse {
    private int id;
    private String role;
    private String login;
    private String email;

    private List<PurchaseResponse> purchaseResponses;

    public UserResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.login = user.getLogin();
        this.role = user.getRole().name();
        this.purchaseResponses = user.getPurchases().stream()
                .map(PurchaseResponse::new)
                .collect(Collectors.toList());
    }
}
