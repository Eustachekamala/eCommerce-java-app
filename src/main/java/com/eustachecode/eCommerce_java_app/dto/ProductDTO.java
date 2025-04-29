package com.eustachecode.eCommerce_java_app.dto;

import com.eustachecode.eCommerce_java_app.models.Category;

import java.util.List;

public record ProductDTO(
        Integer productId,
        String productName,
        int stock,
        double price,
        String imageUrl,
        Integer categoryId,
        List<Integer> orderItems
) {
}
