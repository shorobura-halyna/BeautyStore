package com.beautystore.service;

import com.beautystore.dto.response.DataResponse;
import com.beautystore.dto.response.SubcategoryResponse;
import com.beautystore.model.Subcategory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public interface SubcategoryService {
    void save(Subcategory subcategory);

    void delete(int id);

    void save(String subcategoryName, int categoryId);

    DataResponse<SubcategoryResponse> findAll(Integer page,
                                              Integer size,
                                              String sortBy,
                                              Sort.Direction direction,
                                              String subcategoryName);
}
