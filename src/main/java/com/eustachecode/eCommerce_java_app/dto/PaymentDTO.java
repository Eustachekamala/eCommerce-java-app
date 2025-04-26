package com.eustachecode.eCommerce_java_app.dto;

import com.eustachecode.eCommerce_java_app.models.Order;

import java.util.Date;

public record PaymentDTO(
        Integer paymentId,
        Order order,
        double amount,
        Date paymentDate,
        String paymentStatus
) {
}
