package com.eustachecode.eCommerce_java_app.mappers;

import com.eustachecode.eCommerce_java_app.dto.PaymentDTO;
import com.eustachecode.eCommerce_java_app.models.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    Payment toPayment(PaymentDTO paymentDTO);
    PaymentDTO toPaymentDTO(Payment payment);
}
