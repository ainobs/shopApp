package com.ecommerce.shopApp.service;

import com.ecommerce.shopApp.model.Product;
import com.ecommerce.shopApp.payload.ProductDTO;
import com.ecommerce.shopApp.payload.ProductResponse;

public interface ProductService {
    ProductDTO addProduct(Product product, Long categoryId);

    ProductResponse getAllProducts();

    ProductResponse searchByCategory(Long categoryId);
}
