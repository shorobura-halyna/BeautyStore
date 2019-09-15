package com.beautystore.service.impl;

import com.beautystore.dao.CommodityDao;
import com.beautystore.model.Commodity;
import com.beautystore.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityDao commodityDao;

    @Override
    public void save(Commodity commodity) {
//        commodity.setName(commodity.getName().toUpperCase());
        commodityDao.save(commodity);
    }
}
