package com.beautystore.controller;

import com.beautystore.dto.response.CategoryResponse;
import com.beautystore.dto.response.DataResponse;
import com.beautystore.model.Category;
import com.beautystore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public HttpStatus save(@RequestParam String categoryName) {// categoryName - назва параметру має бути та сама щой на формі
        Category category = new Category();
        category.setName(categoryName);
        categoryService.save(category);
        return HttpStatus.OK;
    }

    @GetMapping()
    public DataResponse<CategoryResponse> findAll(@RequestParam Integer page,
                                                  @RequestParam Integer size,
                                                  @RequestParam String sortBy,
                                                  @RequestParam Sort.Direction direction,
                                                  @RequestParam(required = false) String name) {
        return categoryService.findAll(page, size, sortBy, direction, name);
    }

    @GetMapping("{id}")
    public HttpStatus delete(@PathVariable int id) {
        categoryService.delete(id);
        return HttpStatus.OK;
    }

    @PutMapping
    public HttpStatus update(@RequestParam int id,
                             @RequestParam String categoryName) {
        Category category = new Category();
        category.setId(id);
        category.setName(categoryName);
        categoryService.save(category);
        return HttpStatus.OK;
    }

}
