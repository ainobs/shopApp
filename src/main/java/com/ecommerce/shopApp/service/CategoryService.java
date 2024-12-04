package com.ecommerce.shopApp.service;

import com.ecommerce.shopApp.model.Category;
import com.ecommerce.shopApp.payload.CategoryDTO;
import com.ecommerce.shopApp.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize);

    CategoryDTO addCategory(CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(Long categoryId);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);

}


    