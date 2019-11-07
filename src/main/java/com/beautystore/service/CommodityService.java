package com.beautystore.service;

import com.beautystore.dto.request.CommodityRequest;
import com.beautystore.dto.request.filter.FilterCommodityRequest;
import com.beautystore.dto.response.CommodityResponse;
import com.beautystore.dto.response.DataResponse;
import com.beautystore.model.Commodity;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommodityService {
    void save(CommodityRequest commodityRequest);
    void update(CommodityRequest commodityRequest);

    DataResponse<CommodityResponse> findAll(Integer page,
                                            Integer size,
                                            String sortBy,
                                            Sort.Direction direction,
                                            String name);

    CommodityResponse findOne(int id);

    void delete(int id);

    List<CommodityResponse> filter(FilterCommodityRequest filterCommodityRequest);
}
