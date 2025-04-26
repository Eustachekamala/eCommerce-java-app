package com.eustachecode.eCommerce_java_app.dto;

import com.eustachecode.eCommerce_java_app.models.Order;
import com.eustachecode.eCommerce_java_app.models.Product;

public record OrderItemDTO(
        Integer orderItemId,
        Integer orderId,
        Integer productId,
        int quantity
) {
}
