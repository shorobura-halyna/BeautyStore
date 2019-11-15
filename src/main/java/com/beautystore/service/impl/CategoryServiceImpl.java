package com.beautystore.service.impl;

import com.beautystore.dao.CategoryDao;
import com.beautystore.dao.SubcategoryDao;
import com.beautystore.dto.request.CategoryRequest;
import com.beautystore.dto.response.CategoryResponse;
import com.beautystore.dto.response.DataResponse;
import com.beautystore.model.Category;
import com.beautystore.model.Subcategory;
import com.beautystore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private SubcategoryDao subcategoryDao;

    @Override
    public void save(CategoryRequest categoryRequest) {
        categoryDao.save(new Category(categoryRequest));
    }

    @Override
    public void update(CategoryRequest categoryRequest) {
        categoryDao.save(new Category(categoryRequest.getId(), categoryRequest.getName()));
    }

    /**
     * detach category subcategories from this category
     * and delete this category
     */
    @Override
    public void delete(int id) {
        Category category = categoryDao.getOne(id);
        for (Subcategory subcategory : category.getSubcategories()) {
            subcategory.setCategory(null);
            subcategoryDao.save(subcategory);
        }
        categoryDao.deleteById(id);
    }

    @Override
    public DataResponse<CategoryResponse> findAll(Integer page,
                                                  Integer size,
                                                  String sortBy,
                                                  Sort.Direction direction,
                                                  String name) {
        Sort sort = Sort.by(direction, sortBy);
        Page<Category> purchasePage;
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        if (name != null) {
            purchasePage = categoryDao.findAllByNameLike(name, pageRequest);
        } else {
            purchasePage = categoryDao.findAll(pageRequest);
        }
        return new DataResponse<>(purchasePage.getContent().stream()
                .map(CategoryResponse::new)
                .collect(Collectors.toList()), purchasePage);
    }

    @Override
    public DataResponse<CategoryResponse> findAll() {
        return new DataResponse<>(categoryDao.findAll().stream()
                .map(CategoryResponse::new)
                .collect(Collectors.toList()));
    }
}
