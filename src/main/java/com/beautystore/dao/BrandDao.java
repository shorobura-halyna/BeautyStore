package com.beautystore.dao;

import com.beautystore.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BrandDao extends JpaRepository<Brand, Integer>{
    @Query(value = "select b from Brand b left join fetch b.commodities where b.id=: id")
    Brand findBrandWithCommodities(@Param("id") int id);

    Page<Brand> findAllByNameLike(String name, Pageable pageable);
}
