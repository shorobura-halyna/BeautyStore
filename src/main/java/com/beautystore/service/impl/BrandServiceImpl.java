package com.beautystore.service.impl;

import com.beautystore.dao.BrandDao;
import com.beautystore.model.Brand;
import com.beautystore.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandDao brandDao;

    @Override
    public void save(Brand brand) {
      brandDao.save(brand);
    }

    @Override
    public List<Brand> findAll() {
        return brandDao.findAll();
    }

    @Override
    public void delete(int id) {
     brandDao.deleteById(id);
    }
}
