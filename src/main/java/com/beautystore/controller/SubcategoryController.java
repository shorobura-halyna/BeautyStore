package com.beautystore.controller;

import com.beautystore.model.Subcategory;
import com.beautystore.service.CategoryService;
import com.beautystore.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/subcategory")
public class SubcategoryController {
    @Autowired
    private SubcategoryService subcategoryService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public String save(@RequestParam String subcategoryName,
                       @RequestParam Integer categoryId){
        subcategoryService.save(subcategoryName, categoryId);
        return  "redirect:/subcategory";
    }

    @GetMapping
    public String find(Model model){
        model.addAttribute("subcategories", subcategoryService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "subcategory";
    }


}
