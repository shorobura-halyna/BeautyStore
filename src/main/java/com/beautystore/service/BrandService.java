package com.beautystore.service;

import com.beautystore.model.Brand;

import java.util.List;

public interface BrandService {
    void save(Brand brand);
    List<Brand> findAll();
    void delete (int id);
}
