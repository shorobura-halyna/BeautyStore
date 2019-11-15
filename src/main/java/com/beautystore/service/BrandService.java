package com.beautystore.service;

import com.beautystore.dto.request.BrandRequest;
import com.beautystore.dto.response.BrandResponse;
import com.beautystore.dto.response.DataResponse;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public interface BrandService {
    void save(BrandRequest brandRequest);

    void update(BrandRequest brandRequest);

    void delete(int id);

    DataResponse<BrandResponse> findAll(Integer page,
                                        Integer size,
                                        String sortBy,
                                        Sort.Direction direction,
                                        String name);

    DataResponse<BrandResponse> findAll();
}
