package com.beautystore.service;

import com.beautystore.dto.response.DataResponse;
import com.beautystore.dto.response.PurchaseResponse;
import com.beautystore.model.Purchase;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public interface PurchaseService {
    void save(Purchase purchase);

    void delete(int id);

    DataResponse<PurchaseResponse> findAll(Integer page,
                                           Integer size,
                                           String sortBy,
                                           Sort.Direction direction,
                                           Integer id);

}
