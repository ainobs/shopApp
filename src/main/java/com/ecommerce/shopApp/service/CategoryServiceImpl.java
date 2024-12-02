package com.ecommerce.shopApp.service;

import com.ecommerce.shopApp.exceptions.APIException;
import com.ecommerce.shopApp.exceptions.ResourceNotFoundException;
import com.ecommerce.shopApp.model.Category;
import com.ecommerce.shopApp.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    //private List<Category> cat = new ArrayList<>();
    //private Long nextID = 1L;

    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        if(categoryRepository.count() == 0) {
            throw new APIException("No category found. Try adding a categoey");
        }
        return categoryRepository.findAll();
    }

    @Override
    public void addCategory(Category category) {
        //category.setCategoryId(nextID++);
        Category savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if(savedCategory != null) {
            throw new APIException("Category with name " + category.getCategoryName() + " already exists!!!");
        }
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        categoryRepository.delete(category);

        return "category with id: " + categoryId + " deleted successfully";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Category selectedCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        category.setCategoryId(categoryId);
        return categoryRepository.save(category);

    }
}
