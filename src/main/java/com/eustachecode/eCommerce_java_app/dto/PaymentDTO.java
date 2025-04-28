package com.eustachecode.eCommerce_java_app.dto;


import com.eustachecode.eCommerce_java_app.models.Currency;
import com.eustachecode.eCommerce_java_app.models.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PaymentDTO(
        Integer paymentId,
        Integer orderId,
        BigDecimal amount,
        Currency currency,
        LocalDate paymentDate,
        PaymentStatus paymentStatus
) {
}
