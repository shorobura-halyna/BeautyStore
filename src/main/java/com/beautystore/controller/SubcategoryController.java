package com.beautystore.controller;

import com.beautystore.dto.request.SubcategoryRequest;
import com.beautystore.dto.response.DataResponse;
import com.beautystore.dto.response.SubcategoryResponse;
import com.beautystore.model.Subcategory;
import com.beautystore.service.CategoryService;
import com.beautystore.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/subcategory")
@CrossOrigin
public class SubcategoryController {
    @Autowired
    private SubcategoryService subcategoryService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public HttpStatus save(@RequestBody @Valid SubcategoryRequest subcategoryRequest) {
        subcategoryService.save(subcategoryRequest);
        return HttpStatus.OK;
    }

    @GetMapping
    public DataResponse<SubcategoryResponse> findAll(@RequestParam Integer page,
                                                     @RequestParam Integer size,
                                                     @RequestParam String sortBy,
                                                     @RequestParam Sort.Direction direction,
                                                     @RequestParam(required = false) String name) {
        return subcategoryService.findAll(page, size, sortBy, direction, name);
    }

    @GetMapping("/all")
    public DataResponse<SubcategoryResponse> findAll() {
        return subcategoryService.findAll();
    }

    @PutMapping
    public HttpStatus update(@RequestBody @Valid SubcategoryRequest subcategoryRequest) {
        subcategoryService.update(subcategoryRequest);
        return HttpStatus.OK;
    }

    @DeleteMapping
    public HttpStatus delete(@RequestParam int id) {
        subcategoryService.delete(id);
        return HttpStatus.OK;
    }

}
