package com.beautystore.dao;

import com.beautystore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Integer> {
    void deleteById(int id);
}
