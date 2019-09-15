package com.beautystore.service;

import com.beautystore.model.Category;

import java.util.List;

public interface CategoryService {
    void save(Category category);
    List<Category> findAll();

    void delete(int id);
}
