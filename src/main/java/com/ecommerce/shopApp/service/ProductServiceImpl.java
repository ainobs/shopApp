package com.ecommerce.shopApp.service;

import com.ecommerce.shopApp.model.Product;
import com.ecommerce.shopApp.payload.ProductDTO;
import com.ecommerce.shopApp.repositories.CategoryRepository;
import com.ecommerce.shopApp.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDTO addProduct(Product product, Long categoryId) {
        return null;
    }
}
