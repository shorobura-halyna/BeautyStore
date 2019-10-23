package com.beautystore.controller;

import com.beautystore.model.Purchase;
import com.beautystore.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Purchase> findAll() {
        return purchaseService.findAll();
    }

    @DeleteMapping
    public HttpStatus delete(@RequestParam int id) {
        purchaseService.delete(id);
        return HttpStatus.OK;
    }
}
