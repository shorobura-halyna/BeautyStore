package com.beautystore.service.impl;

import com.beautystore.dao.BasketDao;
import com.beautystore.model.Basket;
import com.beautystore.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {
    @Autowired
    private BasketDao basketDao;

    @Override
    public void delete(int id) {
        basketDao.deleteById(id);
    }

    @Override
    public List<Basket> findAll() {
        return basketDao.findAll();
    }
}
