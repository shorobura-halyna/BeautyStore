package com.beautystore.controller;

import com.beautystore.model.Commodity;
import com.beautystore.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @PostMapping
    public HttpStatus save(@RequestParam String commodityName) {
        Commodity commodity = new Commodity();
        commodity.setName(commodityName);
        commodityService.save(commodity);
        return HttpStatus.OK;
    }

    @PutMapping
    public HttpStatus update(@RequestParam int id,
                             @RequestParam String commodityName) {
        Commodity commodity = new Commodity();
        commodity.setId(id);
        commodity.setName(commodityName);
        commodityService.save(commodity);
        return HttpStatus.OK;
    }

    @GetMapping
    public List<Commodity> find(@RequestParam Integer page, @RequestParam Integer size,
                                @RequestParam String sortBy, @RequestParam Sort.Direction direction,
                                @RequestParam(required = false) String name) {
        return commodityService.findAll(page, size, sortBy, direction, name);
    }

    @DeleteMapping
    public HttpStatus delete(@RequestParam int id) {
        commodityService.delete(id);
        return HttpStatus.OK;
    }
}
