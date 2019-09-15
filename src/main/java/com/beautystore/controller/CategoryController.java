package com.beautystore.controller;

import com.beautystore.model.Category;
import com.beautystore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public String save(@RequestParam String categoryName) {// categoryName - назва параметру має бути та сама щой на формі
        Category category = new Category();
        category.setName(categoryName);
        categoryService.save(category);
        return "redirect:/category";
    }

    //    @RequestMapping(value = "/category", method = RequestMethod.GET)
//    @GetMapping("/category")
    @GetMapping
    public String find(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "category";
    }

    @GetMapping("{id}")
    public String delete(@PathVariable int id) {
        categoryService.delete(id);
        return "redirect:/category";
    }

}
