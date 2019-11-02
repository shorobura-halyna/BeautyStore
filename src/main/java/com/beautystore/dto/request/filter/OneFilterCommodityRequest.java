package com.beautystore.dto.request.filter;

import com.beautystore.dto.request.filter.criteria.CommoditySearchCriteria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OneFilterCommodityRequest {
    private CommoditySearchCriteria commoditySearchCriteria;
    private String firstValue;

    private String secondValue;
}
