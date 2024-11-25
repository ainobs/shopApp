package com.ecommerce.shopApp.controller;

import com.ecommerce.shopApp.model.Category;
import com.ecommerce.shopApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/public/categories")
    public List<Category> getAllCategories () {
        return categoryService.getAllCategories();
    }

    @PostMapping("/public/categories")
    public String addNewCategory (@RequestBody Category category) {
        categoryService.addCategory(category);
        return "Category added successfully";
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId) {
       String status =  categoryService.deleteCategory(categoryId);
       return status;
    }
}
