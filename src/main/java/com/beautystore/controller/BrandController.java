package com.beautystore.controller;

import com.beautystore.dto.request.BrandRequest;
import com.beautystore.dto.response.BrandResponse;
import com.beautystore.dto.response.DataResponse;
import com.beautystore.model.Brand;
import com.beautystore.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    public HttpStatus save(@RequestBody @Valid BrandRequest brandRequest) {
        brandService.save(brandRequest);
        return HttpStatus.OK;
    }

    @PutMapping
    public HttpStatus update(@RequestParam int id,
                             @RequestParam String brandName) {
        brandService.save(new Brand(id, brandName));
        return HttpStatus.OK;
    }

    @GetMapping
    public DataResponse<BrandResponse> findAll(@RequestParam Integer page,
                                               @RequestParam Integer size,
                                               @RequestParam String sortBy,
                                               @RequestParam Sort.Direction direction,
                                               @RequestParam(required = false) String subcategoryName) {
        return brandService.findAll(page, size, sortBy, direction, subcategoryName);
    }

    @DeleteMapping
    public HttpStatus delete(@RequestParam int id) {
        brandService.delete(id);
        return HttpStatus.OK;
    }
}
