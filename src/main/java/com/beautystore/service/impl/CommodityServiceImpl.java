package com.beautystore.service.impl;

import com.beautystore.dao.BrandDao;
import com.beautystore.dao.CommodityDao;
import com.beautystore.dao.SubcategoryDao;
import com.beautystore.dto.request.CommodityRequest;
import com.beautystore.dto.request.filter.FilterCommodityRequest;
import com.beautystore.dto.response.CommodityResponse;
import com.beautystore.dto.response.DataResponse;
import com.beautystore.model.Brand;
import com.beautystore.model.Commodity;
import com.beautystore.model.Subcategory;
import com.beautystore.service.CommodityService;
import com.beautystore.specification.CommoditySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityDao commodityDao;
    @Autowired
    private SubcategoryDao subcategoryDao;
    @Autowired
    private BrandDao brandDao;

    @Override
    public void save(CommodityRequest commodityRequest) {
        Brand brand = brandDao.getOne(commodityRequest.getBrandId());
        Subcategory subcategory = subcategoryDao.getOne(commodityRequest.getSubcategoryId());
        commodityDao.save(new Commodity(commodityRequest, brand, subcategory));
    }

    @Override
    public void update(CommodityRequest commodityRequest) {
        Brand brand = brandDao.getOne(commodityRequest.getBrandId());
        Subcategory subcategory = subcategoryDao.getOne(commodityRequest.getSubcategoryId());
        commodityDao.save(new Commodity(commodityRequest, brand, subcategory));
    }

    @Override
    public DataResponse<CommodityResponse> findAll(Integer page,
                                                   Integer size,
                                                   String sortBy,
                                                   Sort.Direction direction,
                                                   String name) {
        Sort sort = Sort.by(direction, sortBy);
        Page<Commodity> commodityPage;
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        if (name != null) {
            commodityPage = commodityDao.findAllByNameLike(name, pageRequest);
        } else {
            commodityPage = commodityDao.findAll(pageRequest);
        }
        return new DataResponse<>(commodityPage.getContent().stream()
                .map(CommodityResponse::new)
                .collect(Collectors.toList()), commodityPage);
    }

    @Override
    public void delete(int id) {
        commodityDao.deleteById(id);
    }

    @Override
    public List<CommodityResponse> filter(FilterCommodityRequest filterCommodityRequest) {
        CommoditySpecification commoditySpecification = new CommoditySpecification(filterCommodityRequest);
        return commodityDao.findAll(commoditySpecification).stream()
                .map(CommodityResponse::new)
                .collect(Collectors.toList());
    }

}
