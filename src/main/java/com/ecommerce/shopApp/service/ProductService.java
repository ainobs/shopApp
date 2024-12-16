package com.ecommerce.shopApp.service;

import com.ecommerce.shopApp.model.Product;
import com.ecommerce.shopApp.payload.ProductDTO;

public interface ProductService {
    ProductDTO addProduct(Product product, Long categoryId);
}
