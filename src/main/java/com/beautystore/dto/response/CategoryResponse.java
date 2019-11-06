package com.beautystore.dto.response;

import com.beautystore.model.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CategoryResponse {
    private int id;
    private String name;
    private List<SubcategoryResponse> subcategoriesResponse;

    public CategoryResponse(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.subcategoriesResponse = category.getSubcategories().stream()
                .map(SubcategoryResponse::new)
                .collect(Collectors.toList());
    }
}
