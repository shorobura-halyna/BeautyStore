package com.beautystore.service;

import com.beautystore.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    void save(Category category);
    List<Category> findAll();
    void delete (int id);
}
