package com.beautystore.dao;

import com.beautystore.model.Subcategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubcategoryDao extends JpaRepository<Subcategory, Integer> {
    Page<Subcategory> findAllByNameLike(String subcategoryName, Pageable pageable);
}
