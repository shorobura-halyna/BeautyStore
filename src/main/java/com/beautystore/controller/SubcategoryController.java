package com.beautystore.controller;

import com.beautystore.dto.response.DataResponse;
import com.beautystore.dto.response.SubcategoryResponse;
import com.beautystore.model.Subcategory;
import com.beautystore.service.CategoryService;
import com.beautystore.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subcategory")
public class SubcategoryController {
    @Autowired
    private SubcategoryService subcategoryService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public HttpStatus save(@RequestParam String subcategoryName,
                           @RequestParam int categoryId) {
        subcategoryService.save(subcategoryName, categoryId);
        return HttpStatus.OK;
    }

//    @GetMapping
//    public HttpStatus find(Model model){
//        model.addAttribute("subcategories", subcategoryService.findAll());
//        model.addAttribute("categories", categoryService.findAll());
//        return HttpStatus.OK;
//    }

    @GetMapping
    public DataResponse<SubcategoryResponse> findAll(@RequestParam Integer page,
                                                     @RequestParam Integer size,
                                                     @RequestParam String sortBy,
                                                     @RequestParam Sort.Direction direction,
                                                     @RequestParam(required = false) String secondName) {
        return subcategoryService.findAll(page, size, sortBy, direction, secondName);
    }

    @PutMapping
    public HttpStatus update(@RequestParam int id,
                             @RequestParam String subcategoryName) {
        Subcategory subcategory = new Subcategory();
        subcategory.setId(id);
        subcategory.setName(subcategoryName);
        subcategoryService.save(subcategory);
        return HttpStatus.OK;
    }

    @DeleteMapping
    public HttpStatus delete(@RequestParam int id) {
        subcategoryService.delete(id);
        return HttpStatus.OK;
    }

}
