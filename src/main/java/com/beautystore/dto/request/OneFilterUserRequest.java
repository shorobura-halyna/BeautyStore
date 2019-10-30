package com.beautystore.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OneFilterUserRequest {
    private  UserSearchCriteria userSearchCriteria;

    private String firstValue;

    private String secondValue;
}
