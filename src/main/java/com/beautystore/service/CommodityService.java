package com.beautystore.service;

import com.beautystore.dto.request.CommodityRequest;
import com.beautystore.dto.request.filter.FilterCommodityRequest;
import com.beautystore.dto.response.CommodityResponse;
import com.beautystore.dto.response.DataResponse;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface CommodityService {
    CommodityResponse save(CommodityRequest commodityRequest, MultipartFile file);

    void update(CommodityRequest commodityRequest);

    DataResponse<CommodityResponse> findAll(Integer page,
                                            Integer size,
                                            String sortBy,
                                            Sort.Direction direction,
                                            String name);

    CommodityResponse findOne(int id);

    void delete(int id);

    DataResponse<CommodityResponse> filter(Integer page,
                                           Integer size,
                                           String sortBy,
                                           Sort.Direction direction,
                                           FilterCommodityRequest filterCommodityRequest);

    int getMaxPrice();
}
