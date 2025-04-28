package com.eustachecode.eCommerce_java_app.dto;

public record OrderItemDTO(
        Integer orderItemId,
        Integer orderId,
        Integer productId,
        int quantity
) {
}
