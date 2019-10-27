package com.beautystore.service.impl;

import com.beautystore.dao.BrandDao;
import com.beautystore.dto.response.BrandResponse;
import com.beautystore.dto.response.DataResponse;
import com.beautystore.model.Brand;
import com.beautystore.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandDao brandDao;

    @Override
    public void save(Brand brand) {
        brandDao.save(brand);
    }

    @Override
    public void delete(int id) {
        brandDao.deleteById(id);
    }

    @Override
    public DataResponse<BrandResponse> findAll(Integer page,
                                                Integer size,
                                                String sortBy,
                                                Sort.Direction direction,
                                                String name) {
        Sort sort = Sort.by(direction, sortBy);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Brand> brandPage;
        if (name != null) {
            brandPage = brandDao.findAllByNameLike(name, pageRequest);
        } else {
            brandPage = brandDao.findAll(pageRequest);
        }
        return new DataResponse<>(brandPage.getContent().stream()
             .map(BrandResponse::new)
                .collect(Collectors.toList()), brandPage);
    }



}
