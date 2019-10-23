package com.beautystore.dto.request;

import com.beautystore.dto.response.SubcategoryResponse;

import java.util.ArrayList;
import java.util.List;

public class CategoryRequest {
    private String name;
    private List<SubcategoryRequest> subcategories = new ArrayList<>();
}
