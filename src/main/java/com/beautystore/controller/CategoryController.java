package com.beautystore.controller;

import com.beautystore.dto.request.CategoryRequest;
import com.beautystore.dto.response.CategoryResponse;
import com.beautystore.dto.response.DataResponse;
import com.beautystore.model.Category;
import com.beautystore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public HttpStatus save(@RequestBody @Valid CategoryRequest categoryRequest) {// categoryName - назва параметру має бути та сама щой на формі
        categoryService.save(categoryRequest);
        return HttpStatus.OK;
    }

    @GetMapping
    public DataResponse<CategoryResponse> findAll(@RequestParam Integer page,
                                                  @RequestParam Integer size,
                                                  @RequestParam String sortBy,
                                                  @RequestParam Sort.Direction direction,
                                                  @RequestParam(required = false) String name) {
        return categoryService.findAll(page, size, sortBy, direction, name);
    }

    @GetMapping("/all")
    public DataResponse<CategoryResponse> findAll() {
        return categoryService.findAll();
    }

    @DeleteMapping
    public HttpStatus delete(@RequestParam int id) {
        categoryService.delete(id);
        return HttpStatus.OK;
    }

    @PutMapping
    public HttpStatus update(@RequestBody @Valid CategoryRequest categoryRequest) {
        categoryService.update(categoryRequest);
        return HttpStatus.OK;
    }

}
