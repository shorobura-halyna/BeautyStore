package com.beautystore.dao;

import com.beautystore.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandDao extends JpaRepository<Brand, Integer> {
    Page<Brand> findAllByNameLike(String name, Pageable pageable);
}
