package com.ecommerce.shopApp.repositories;

import com.ecommerce.shopApp.model.Category;
import com.ecommerce.shopApp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryOrderByPriceAsc(Category category);
}
