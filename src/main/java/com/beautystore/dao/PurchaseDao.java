package com.beautystore.dao;

import com.beautystore.model.Purchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseDao extends JpaRepository<Purchase, Integer> {
    void findAllByCommoditiesContaining(String commodity);

    Page<Purchase> findAllById(Integer id, Pageable pageable);

}
