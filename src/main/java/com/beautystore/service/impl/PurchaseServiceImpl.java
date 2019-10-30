package com.beautystore.service.impl;

import com.beautystore.dao.PurchaseDao;
import com.beautystore.dto.response.DataResponse;
import com.beautystore.dto.response.PurchaseResponse;
import com.beautystore.model.Purchase;
import com.beautystore.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseDao purchaseDao;

    @Override
    public DataResponse<PurchaseResponse> findAll(Integer page,
                                                  Integer size,
                                                  String sortBy,
                                                  Sort.Direction direction,
                                                  Integer id) {
        Sort sort = Sort.by(direction, sortBy);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Purchase> purchasePage;
        if (id != null) {
            purchasePage = purchaseDao.findAllById(id, pageRequest);
        } else {
            purchasePage = purchaseDao.findAll(pageRequest);
        }
        return new DataResponse<>(purchasePage.getContent().stream()
                .map(PurchaseResponse::new)
                .collect(Collectors.toList()), purchasePage);
    }

    @Override
    public void delete(int id) {
        purchaseDao.deleteById(id);
    }
}
