package com.beautystore.service.impl;

import com.beautystore.dao.CommodityDao;
import com.beautystore.model.Commodity;
import com.beautystore.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityDao commodityDao;

    @Override
    public void save(Commodity commodity) {
//        commodity.setName(commodity.getName().toUpperCase());
        commodityDao.save(commodity);

    }

    @Override
    public List<Commodity> findAll(Integer page,
                                   Integer size,
                                   String sortBy, @RequestParam Sort.Direction direction,
                                   @RequestParam(required = false) String name) {
        return commodityDao.findAll();
    }

    @Override
    public void delete(int id) {
     commodityDao.deleteById(id);
    }
}
