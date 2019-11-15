package com.beautystore.dao;

import com.beautystore.model.Commodity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface CommodityDao extends JpaRepository<Commodity, Integer>, JpaSpecificationExecutor<Commodity> {
    Page<Commodity> findAllByNameLike(String name, Pageable pageable);

    @Query("select max(c.price) from Commodity c")
    int findMaxPrice();
}
