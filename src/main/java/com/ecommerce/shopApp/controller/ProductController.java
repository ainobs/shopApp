package com.ecommerce.shopApp.controller;

import com.ecommerce.shopApp.model.Product;
import com.ecommerce.shopApp.payload.ProductDTO;
import com.ecommerce.shopApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/admin/categories/{categoryId}/product")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody Product product, @PathVariable Long categoryId) {
        ProductDTO productDTO = productService.addProduct(product, categoryId);
        return productDTO;
    }
}
