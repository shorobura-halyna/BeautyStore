package com.beautystore.dto.response;

import com.beautystore.model.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CategoryResponse {
    private String name;
    private List<SubcategoryResponse> subcategoriesResponse = new ArrayList<>();

    public CategoryResponse(Category category) {
        this.name = category.getName();
        this.subcategoriesResponse = category.getSubcategories().stream()
        .map(SubcategoryResponse::new)
        .collect(Collectors.toList());
    }
}
