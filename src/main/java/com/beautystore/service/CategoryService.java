package com.beautystore.service;

import com.beautystore.dto.request.CategoryRequest;
import com.beautystore.dto.response.CategoryResponse;
import com.beautystore.dto.response.DataResponse;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    void save(CategoryRequest categoryRequest);
    void update(CategoryRequest categoryRequest);

    void delete(int id);

    DataResponse<CategoryResponse> findAll(Integer page,
                                           Integer size,
                                           String sortBy,
                                           Sort.Direction direction,
                                           String name);
    DataResponse<CategoryResponse> findAll();
}
