package com.beautystore.controller;

import com.beautystore.dto.response.DataResponse;
import com.beautystore.dto.response.PurchaseResponse;
import com.beautystore.model.Purchase;
import com.beautystore.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @PostMapping
    public HttpStatus save(@RequestParam int id) {
        Purchase purchase = new Purchase();
        purchase.setId(id);
        purchaseService.save(purchase);
        return HttpStatus.OK;
    }

    @PutMapping
    public HttpStatus update(@RequestParam int id) {
        Purchase purchase = new Purchase();
        purchase.setId(id);
        purchaseService.save(purchase);
        return HttpStatus.OK;
    }

    @GetMapping
    public DataResponse<PurchaseResponse> findAll(@RequestParam Integer page,
                                                  @RequestParam Integer size,
                                                  @RequestParam String sortBy,
                                                  @RequestParam Sort.Direction direction,
                                                  @RequestParam(required = false) Integer id) {
        return purchaseService.findAll(page, size, sortBy, direction, id);
    }

    @DeleteMapping
    public HttpStatus delete(@RequestParam int id) {
        purchaseService.delete(id);
        return HttpStatus.OK;
    }
}
