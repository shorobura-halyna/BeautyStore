package com.beautystore.service.impl;

import com.beautystore.dao.CategoryDao;
import com.beautystore.dao.SubcategoryDao;
import com.beautystore.dto.request.SubcategoryRequest;
import com.beautystore.dto.response.DataResponse;
import com.beautystore.dto.response.SubcategoryResponse;
import com.beautystore.model.Category;
import com.beautystore.model.Subcategory;
import com.beautystore.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

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
    public void save(SubcategoryRequest subcategoryRequest) {
        Category category = categoryDao.getOne(subcategoryRequest.getCategoryId());
        subcategoryDao.save(new Subcategory(subcategoryRequest, category));
    }

    @Override
    public void save(Subcategory subcategory) {
    subcategoryDao.save(subcategory);
    }

    @Override
    public DataResponse<SubcategoryResponse> findAll(Integer page,
                                                     Integer size,
                                                     String sortBy,
                                                     Sort.Direction direction,
                                                     String subcategoryName) {
        Sort sort = Sort.by(direction, sortBy);
        Page<Subcategory> subcategoryPage;
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        if (subcategoryName != null) {
            subcategoryPage = subcategoryDao.findAllByNameLike("%" + subcategoryName + "%", pageRequest);
        } else {
            subcategoryPage = subcategoryDao.findAll(pageRequest);
        }
        return new DataResponse<>(subcategoryPage.getContent().stream()
                .map(SubcategoryResponse::new)
                .collect(Collectors.toList()), subcategoryPage);
    }

    @Override
    public void delete(int id) {
        subcategoryDao.deleteById(id);
    }
}
