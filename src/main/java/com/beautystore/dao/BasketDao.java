package com.beautystore.dao;

import com.beautystore.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketDao extends JpaRepository<Basket, Integer> {
  void deleteById(int id);
}
