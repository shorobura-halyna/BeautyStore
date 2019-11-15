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
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.stream.Collectors;

import static java.nio.file.Paths.get;
import static java.util.Objects.requireNonNull;

@Log4j2
@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityDao commodityDao;
    @Autowired
    private SubcategoryDao subcategoryDao;
    @Autowired
    private BrandDao brandDao;

    @Transactional
    @Override
    public CommodityResponse save(CommodityRequest commodityRequest, MultipartFile file) {
        Commodity commodity = commodityRequestToCommodity(commodityRequest);
        log.info("Original file name -> " + file.getOriginalFilename());
        String[] arrayForGetExpansion = requireNonNull(file.getOriginalFilename().split("\\."));
        String expansion = arrayForGetExpansion[arrayForGetExpansion.length - 1];
        String nameOfFile = commodity.getName() + "." + expansion;
        String fullPath = "src/main/resources/static/" + nameOfFile;
        commodity.setUrlToPicture(nameOfFile);
        commodity = commodityDao.save(commodity);
        try {
            Files.copy(file.getInputStream(), get(fullPath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            log.error("Exception while saving picture " + file.getOriginalFilename());
            e.printStackTrace();
        }
        return new CommodityResponse(commodity);
    }


    private Commodity commodityRequestToCommodity(CommodityRequest commodityRequest) {
        Brand brand = brandDao.getOne(commodityRequest.getBrandId());
        Subcategory subcategory = subcategoryDao.getOne(commodityRequest.getSubcategoryId());
        Commodity commodity = new Commodity(commodityRequest.getName(), commodityRequest.getPrice());
        commodity.setId(commodityRequest.getId());
        commodity.setBrand(brand);
        commodity.setSubcategory(subcategory);
        return commodity;
    }

    @Override
    public void update(CommodityRequest commodityRequest) {
        commodityDao.save((commodityRequestToCommodity(commodityRequest)));
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
    public CommodityResponse findOne(int id) {
        return new CommodityResponse(commodityDao.getOne(id));
    }

    @Override
    public void delete(int id) {
        commodityDao.deleteById(id);
    }

    @Override
    public DataResponse<CommodityResponse> filter(Integer page,
                                                  Integer size,
                                                  String sortBy,
                                                  Sort.Direction direction,
                                                  FilterCommodityRequest filterCommodityRequest) {
        Sort sort = Sort.by(direction, sortBy);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        CommoditySpecification commoditySpecification = new CommoditySpecification(filterCommodityRequest);

        Page<Commodity> commodityPage = commodityDao.findAll(commoditySpecification, pageRequest);
        return new DataResponse<>(commodityPage.stream()
                .map(CommodityResponse::new)
                .collect(Collectors.toList()), commodityPage);
    }

    @Override
    public int getMaxPrice() {
        return commodityDao.findMaxPrice();
    }

}
