package com.beautystore.dao;

import com.beautystore.model.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommodityDao extends JpaRepository<Commodity, Integer> {
//    @Query()
//    Commodity findCommodityWithBaskets(int id);

}
