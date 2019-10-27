package com.beautystore.service;

import com.beautystore.model.Commodity;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public interface CommodityService {
    void save(Commodity commodity);

    List<Commodity> findAll(Integer page,
                            Integer size,
                            String sortBy, @RequestParam Sort.Direction direction,
                            @RequestParam(required = false) String name);

    void delete(int id);
}
