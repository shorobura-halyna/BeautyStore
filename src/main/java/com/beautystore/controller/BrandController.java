package com.beautystore.controller;

import com.beautystore.dto.request.BrandRequest;
import com.beautystore.dto.response.BrandResponse;
import com.beautystore.dto.response.DataResponse;
import com.beautystore.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/brand")
@CrossOrigin
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    public HttpStatus save(@RequestBody @Valid BrandRequest brandRequest) {
        brandService.save(brandRequest);
        return HttpStatus.OK;
    }

    @PutMapping
    public HttpStatus update(@RequestBody @Valid BrandRequest brandRequest) {
        brandService.update(brandRequest);
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

    @GetMapping("/all")
    public DataResponse<BrandResponse> findAll() {
        return brandService.findAll();
    }

    @DeleteMapping
    public HttpStatus delete(@RequestParam int id) {
        brandService.delete(id);
        return HttpStatus.OK;
    }
}
