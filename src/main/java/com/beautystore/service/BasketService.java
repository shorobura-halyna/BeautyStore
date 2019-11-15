package com.beautystore.service;

import com.beautystore.dto.response.BasketResponse;
import com.beautystore.dto.response.DataResponse;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public interface BasketService {
    void delete(int id);

    DataResponse<BasketResponse> findAll(Integer page,
                                         Integer size,
                                         String sortBy,
                                         Sort.Direction direction,
                                         Integer id);

    void addToCart(int id);

    void buy();
}
