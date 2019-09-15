package com.beautystore.service.impl;

import com.beautystore.dao.CategoryDao;
import com.beautystore.dao.SubcategoryDao;
import com.beautystore.model.Category;
import com.beautystore.model.Subcategory;
import com.beautystore.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SubcategoryServiceImpl implements SubcategoryService {
    @Autowired
    private SubcategoryDao subcategoryDao;
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public void save(String subcategoryName, int categoryId) {
        Subcategory subcategory = new Subcategory();
        subcategory.setName(subcategoryName);
        Category category = categoryDao.getOne(categoryId);
        subcategory.setCategory(category);
        subcategoryDao.save(subcategory);
    }

    @Override
    public List<Subcategory> findAll() {
        return subcategoryDao.findAll();
    }

    @Override
    public void delete(int id) {
        subcategoryDao.deleteById(id);
    }
}
