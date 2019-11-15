package com.beautystore.dao;

import com.beautystore.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Integer> {
    Page<Category> findAllByNameLike(String name, Pageable pageable);

}
