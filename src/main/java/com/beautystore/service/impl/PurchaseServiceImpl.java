package com.beautystore.service.impl;

import com.beautystore.dao.PurchaseDao;
import com.beautystore.model.Purchase;
import com.beautystore.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseDao purchaseDao;

    @Override
    public void save(Purchase purchase) {
        purchaseDao.save(purchase);
    }

    @Override
    public List<Purchase> findAll() {
        return purchaseDao.findAll();
    }
    @Override
    public void delete(int id) {
    purchaseDao.deleteById(id);
    }
}
