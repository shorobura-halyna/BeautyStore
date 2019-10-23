package com.beautystore.dto.response;

import com.beautystore.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubcategoryResponse {
    private String name;
    private Category category;

    public SubcategoryResponse(String name, Category category) {
        this.name = name;
        this.category = category;
    }
}
