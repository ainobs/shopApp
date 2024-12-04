package com.ecommerce.shopApp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {
    List<CategoryDTO> content;
    private Integer pageNumber;
    private Integer pageSize;
    private Integer totalElements;
    private Integer totalPages;
    private boolean lastPage;
}
