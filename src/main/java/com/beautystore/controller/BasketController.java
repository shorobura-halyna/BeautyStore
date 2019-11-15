package com.beautystore.controller;

import com.beautystore.dto.response.BasketResponse;
import com.beautystore.dto.response.DataResponse;
import com.beautystore.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basket")
@CrossOrigin
public class BasketController {

    @Autowired
    private BasketService basketService;

    @DeleteMapping
    public HttpStatus delete(@RequestParam int id) {
        basketService.delete(id);
        return HttpStatus.OK;
    }

    @GetMapping
    public DataResponse<BasketResponse> findAll(@RequestParam Integer page,
                                                @RequestParam Integer size,
                                                @RequestParam String sortBy,
                                                @RequestParam Sort.Direction direction,
                                                @RequestParam(required = false) Integer id) {
        return basketService.findAll(page, size, sortBy, direction, id);
    }

   @GetMapping("/addToCart")
    public HttpStatus addToCard(@RequestParam int id){
        basketService.addToCart(id);
        return HttpStatus.OK;
   }
}
