package com.beautystore.controller;

import com.beautystore.dto.response.BasketResponse;
import com.beautystore.dto.response.BrandResponse;
import com.beautystore.dto.response.DataResponse;
import com.beautystore.model.Brand;
import com.beautystore.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    public HttpStatus save(@RequestParam String brandName) {
        Brand brand = new Brand();
        brand.setName(brandName);
        brandService.save(brand);
        return HttpStatus.OK;
    }

    @PutMapping
    public HttpStatus update(@RequestParam int id,
                             @RequestParam String brandName) {
        Brand brand = new Brand();
        brand.setId(id);
        brand.setName(brandName);
        brandService.save(brand);
        return HttpStatus.OK;
    }

    public DataResponse<BrandResponse> findAll(@RequestParam Integer page,
                                               @RequestParam Integer size,
                                               @RequestParam String sortBy,
                                               @RequestParam Sort.Direction direction,
                                               @RequestParam(required = false) String name) {
        return brandService.findAll(page, size, sortBy, direction, name);
    }

    @DeleteMapping
    public HttpStatus delete(@RequestParam int id) {
        brandService.delete(id);
        return HttpStatus.OK;
    }


}
