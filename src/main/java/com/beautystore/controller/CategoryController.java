package com.beautystore.controller;

import com.beautystore.model.Brand;
import com.beautystore.model.Category;
import com.beautystore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
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

    //    @RequestMapping(value = "/category", method = RequestMethod.GET)
//    @GetMapping("/category")
    @GetMapping
    public HttpStatus find(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return HttpStatus.OK;
    }

    @GetMapping("{id}")
    public HttpStatus delete(@RequestParam int id) {
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
