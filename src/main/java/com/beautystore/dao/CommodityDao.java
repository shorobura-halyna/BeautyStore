package com.beautystore.dao;

import com.beautystore.model.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommodityDao extends JpaRepository<Commodity, Integer> {
//    @Query()
//    Commodity findCommodityWithBaskets(int id);

}
