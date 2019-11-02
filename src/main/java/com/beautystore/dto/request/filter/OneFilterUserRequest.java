package com.beautystore.dto.request.filter;

import com.beautystore.dto.request.filter.criteria.UserSearchCriteria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OneFilterUserRequest {
    private UserSearchCriteria userSearchCriteria;

    private String firstValue;

    private String secondValue;
}
