package com.beautystore.dto.response;

import com.beautystore.model.Subcategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubcategoryResponse {
    private String name;
    private String category;

    public SubcategoryResponse(Subcategory subcategory) {
        this.name = subcategory.getName();
        this.category = subcategory.getCategory().getName();
    }
}
