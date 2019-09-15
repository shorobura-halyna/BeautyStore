package com.beautystore.dao;

import com.beautystore.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandDao extends JpaRepository<Brand, Integer> {
    void deleteById(int id);
}
