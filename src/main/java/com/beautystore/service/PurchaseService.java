package com.beautystore.service;

import com.beautystore.model.Purchase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PurchaseService {
    void save(Purchase purchase);
    List<Purchase> findAll();
    void delete (int id);
}
