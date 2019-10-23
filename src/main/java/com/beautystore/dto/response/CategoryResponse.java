package com.beautystore.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoryResponse {
    private String name;
    private List<SubcategoryResponse> subcategories = new ArrayList<>();

}
