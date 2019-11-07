package com.beautystore.dto.response;

import com.beautystore.model.Subcategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubcategoryResponse {
    private int id;
    private String name;
    private String category;

    public SubcategoryResponse(Subcategory subcategory) {
        this.id = subcategory.getId();
        this.name = subcategory.getName();
        this.category = subcategory.getCategory() != null ? subcategory.getCategory().getName() : "";
    }
}
