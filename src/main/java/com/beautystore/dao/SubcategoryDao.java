package com.beautystore.dao;

import com.beautystore.model.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubcategoryDao extends JpaRepository<Subcategory, Integer> {
    void deleteById(int id);
}
