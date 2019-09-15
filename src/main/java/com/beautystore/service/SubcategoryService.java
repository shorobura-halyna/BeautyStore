package com.beautystore.service;

import com.beautystore.model.Subcategory;

import java.util.List;

public interface SubcategoryService {
    void save(String subcategoryName, int categoryId);
    List<Subcategory> findAll();
    void delete (int id);
}
