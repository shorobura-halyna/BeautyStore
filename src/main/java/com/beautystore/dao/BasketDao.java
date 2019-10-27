package com.beautystore.dao;

import com.beautystore.model.Basket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketDao extends JpaRepository<Basket, Integer> {
    void deleteById(int id);

    Page<Basket> findAllById(int id, Pageable pageable);
}
