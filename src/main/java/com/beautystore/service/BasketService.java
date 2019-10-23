package com.beautystore.service;

import com.beautystore.model.Basket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BasketService {
    void delete (int id);
    List<Basket> findAll();

}
