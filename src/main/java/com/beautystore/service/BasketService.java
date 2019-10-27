package com.beautystore.service;

import com.beautystore.dto.response.BasketResponse;
import com.beautystore.dto.response.DataResponse;
import com.beautystore.model.Basket;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BasketService {
    void delete(int id);

    DataResponse<BasketResponse> findAll(Integer page,
                                         Integer size,
                                         String sortBy,
                                         Sort.Direction direction,
                                         Integer id);
}
