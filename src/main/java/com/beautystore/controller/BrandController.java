package com.beautystore.controller;

import com.beautystore.model.Brand;
import com.beautystore.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<Brand> find() {
        return brandService.findAll();
    }

    @DeleteMapping
    public HttpStatus delete(@RequestParam int id) {
        brandService.delete(id);
        return HttpStatus.OK;
    }


}
