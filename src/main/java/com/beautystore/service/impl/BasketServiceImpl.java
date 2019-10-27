package com.beautystore.service.impl;

import com.beautystore.dao.BasketDao;
import com.beautystore.dto.response.BasketResponse;
import com.beautystore.dto.response.DataResponse;
import com.beautystore.model.Basket;
import com.beautystore.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BasketServiceImpl implements BasketService {
    @Autowired
    private BasketDao basketDao;

    @Override
    public void delete(int id) {
        basketDao.deleteById(id);
    }

    @Override
    public DataResponse<BasketResponse> findAll(Integer page,
                                Integer size,
                                String sortBy,
                                Sort.Direction direction,
                                Integer id) {
        Sort sort = Sort.by(direction, sortBy);
        Page<Basket> basketPage;
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        if (id != null) {
            basketPage = basketDao.findAllById(id, pageRequest);
        } else {
            basketPage = basketDao.findAll(pageRequest);
        }
        return new DataResponse<>(basketPage.getContent().stream()
                .map(BasketResponse::new)
                .collect(Collectors.toList()), basketPage);
    }
}
