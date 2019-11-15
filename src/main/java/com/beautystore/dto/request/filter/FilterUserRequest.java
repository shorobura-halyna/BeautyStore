package com.beautystore.dto.request.filter;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FilterUserRequest {
    List<OneFilterUserRequest> oneFilterUserRequests = new ArrayList<>();
}
