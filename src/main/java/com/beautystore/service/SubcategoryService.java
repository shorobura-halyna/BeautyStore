package com.beautystore.service;

import com.beautystore.dto.request.SubcategoryRequest;
import com.beautystore.dto.response.DataResponse;
import com.beautystore.dto.response.SubcategoryResponse;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public interface SubcategoryService {
    void save(SubcategoryRequest subcategoryRequest);

    void update(SubcategoryRequest subcategoryRequest);

    void delete(int id);

    void save(String subcategoryName, int categoryId);

    DataResponse<SubcategoryResponse> findAll(Integer page,
                                              Integer size,
                                              String sortBy,
                                              Sort.Direction direction,
                                              String subcategoryName);

    DataResponse<SubcategoryResponse> findAll();
}
