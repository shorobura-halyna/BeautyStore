package com.beautystore.controller;

import com.beautystore.model.Brand;
import com.beautystore.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping ("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping
    public String save(@RequestParam String brandName){
        Brand brand = new Brand();
        brand.setName(brandName);
        brandService.save(brand);
        return "redirect:/brand";
    }

    @GetMapping
    public String find(Model model){
        model.addAttribute("brands", brandService.findAll());
        return "brand";
    }

    @GetMapping("{id}")
    public String delete(@PathVariable int id) {
        brandService.delete(id);
        return "redirect:/brand";
    }



}
