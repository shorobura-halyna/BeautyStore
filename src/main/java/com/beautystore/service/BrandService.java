package com.beautystore.service;

import com.beautystore.model.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {
    void save(Brand brand);
    List<Brand> findAll();
    void delete (int id);
}
