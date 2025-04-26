package com.eustachecode.eCommerce_java_app.dto;

import com.eustachecode.eCommerce_java_app.models.Customer;

import java.util.Date;
import java.util.List;

public record OrderDTO(
        Integer orderId,
        Integer customerId,
        Date orderDate,
        double totalAmount,
        List<Integer> orderItems,
        List<Integer> products
) {
}
