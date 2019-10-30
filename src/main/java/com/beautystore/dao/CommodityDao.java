package com.beautystore.dao;

import com.beautystore.model.Commodity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommodityDao extends JpaRepository<Commodity, Integer> {
    Page<Commodity> findAllByNameLike(String name, Pageable pageable);
//    @Query()
//    Commodity findCommodityWithBaskets(int id);
}
