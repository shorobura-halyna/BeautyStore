package com.beautystore.service.impl;

import com.beautystore.dao.BrandDao;
import com.beautystore.dto.request.BrandRequest;
import com.beautystore.dto.response.BrandResponse;
import com.beautystore.dto.response.DataResponse;
import com.beautystore.dto.response.SubcategoryResponse;
import com.beautystore.model.Brand;
import com.beautystore.model.Commodity;
import com.beautystore.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandDao brandDao;

    @Override
    public void save(BrandRequest brandRequest) {
        brandDao.save(new Brand(brandRequest));
    }

    @Override
    public void update(BrandRequest brandRequest) {
        brandDao.save(new Brand(brandRequest.getId(), brandRequest.getName()));
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
        List<BrandResponse> brandResponses = brandPage.getContent().stream()
                .map(BrandResponse::new)
                .collect(Collectors.toList());
        return new DataResponse<>(brandResponses, brandPage);
    }

    @Override
    public DataResponse<BrandResponse> findAll() {
        return new DataResponse<>(brandDao.findAll().stream()
                .map(BrandResponse::new)
                .collect(Collectors.toList()));
    }
}
