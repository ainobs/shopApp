package com.ecommerce.shopApp.service;

import com.ecommerce.shopApp.exceptions.APIException;
import com.ecommerce.shopApp.exceptions.ResourceNotFoundException;
import com.ecommerce.shopApp.model.Category;
import com.ecommerce.shopApp.payload.CategoryDTO;
import com.ecommerce.shopApp.payload.CategoryResponse;
import com.ecommerce.shopApp.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{

    //private List<Category> cat = new ArrayList<>();
    //private Long nextID = 1L;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CategoryResponse getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if(categoryRepository.count() == 0) {
            throw new APIException("No category found. Try adding a category");
        }
        List<CategoryDTO> categoryDTO = categories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .toList();
        CategoryResponse  categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTO);
        return categoryResponse;
    }

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        //category.setCategoryId(nextID++);
        Category category = modelMapper.map(categoryDTO, Category.class);
        Category savedCategoryFromDB = categoryRepository.findByCategoryName(category.getCategoryName());
        if(savedCategoryFromDB != null) {
            throw new APIException("Category with name " + category.getCategoryName() + " already exists!!!");
        }
        Category savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDTO.class);
    }

    @Override
    public CategoryDTO deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        categoryRepository.delete(category);
        return modelMapper.map(category, CategoryDTO.class);

        //return "category with id: " + categoryId + " deleted successfully";
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId) {
        Category selectedCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        Category category = modelMapper.map(categoryDTO, Category.class);
        category.setCategoryId(categoryId);
        selectedCategory = categoryRepository.save(category);
        return modelMapper.map(selectedCategory, CategoryDTO.class);

    }
}
