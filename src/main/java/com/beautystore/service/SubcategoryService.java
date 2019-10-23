package com.beautystore.service;

import com.beautystore.model.Subcategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubcategoryService {
    void save(Subcategory subcategory);
    List<Subcategory> findAll();
    void delete (int id);
    void save(String subcategoryName, int categoryId);
}
