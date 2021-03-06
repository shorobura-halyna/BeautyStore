package com.beautystore.service.impl;

import com.beautystore.dao.CategoryDao;
import com.beautystore.dao.CommodityDao;
import com.beautystore.dao.SubcategoryDao;
import com.beautystore.dto.request.SubcategoryRequest;
import com.beautystore.dto.response.DataResponse;
import com.beautystore.dto.response.SubcategoryResponse;
import com.beautystore.model.Category;
import com.beautystore.model.Commodity;
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
    @Autowired
    private CommodityDao commodityDao;

    @Override
    public void save(SubcategoryRequest subcategoryRequest) {
        Category category = categoryDao.getOne(subcategoryRequest.getCategoryId());
        subcategoryDao.save(new Subcategory(subcategoryRequest, category));
    }

    @Override
    public void update(SubcategoryRequest subcategoryRequest) {
        Category category = categoryDao.getOne(subcategoryRequest.getCategoryId());
        subcategoryDao.save(new Subcategory(subcategoryRequest.getId(), subcategoryRequest.getName(), category));
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
    public DataResponse<SubcategoryResponse> findAll() {
        return new DataResponse<>(subcategoryDao.findAll().stream()
                .map(SubcategoryResponse::new)
                .collect(Collectors.toList()));
    }

    /**
     * detach subcategory commodities from this category
     * and delete this category
     */
    @Transactional
    @Override
    public void delete(int id) {
        Subcategory subcategory = subcategoryDao.getOne(id);
        for (Commodity commodity : subcategory.getCommodities()) {
            commodity.setSubcategory(null);
            commodityDao.save(commodity);
        }
        subcategoryDao.deleteById(id);
    }
}
