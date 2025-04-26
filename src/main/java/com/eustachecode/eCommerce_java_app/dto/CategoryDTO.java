package com.eustachecode.eCommerce_java_app.dto;

import com.eustachecode.eCommerce_java_app.models.Product;

import java.util.List;

public record CategoryDTO(
        Integer categoryId,
        String categoryName,
        String description,
        List<Integer> products
) {
}
