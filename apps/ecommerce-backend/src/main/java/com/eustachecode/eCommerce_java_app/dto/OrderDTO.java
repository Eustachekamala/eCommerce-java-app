package com.eustachecode.eCommerce_java_app.dto;

import java.time.LocalDate;
import java.util.List;

public record OrderDTO(
        Integer orderId,
        Integer customerId,
        LocalDate orderDate,
        double totalAmount,
        List<OrderItemDTO> orderItems
) {
    public record OrderItemDTO(
            Integer productId,
            int quantity
    ) {
    }
}
