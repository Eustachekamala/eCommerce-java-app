package com.eustachecode.eCommerce_java_app.mappers;

import com.eustachecode.eCommerce_java_app.dto.PaymentDTO;
import com.eustachecode.eCommerce_java_app.models.Order;
import com.eustachecode.eCommerce_java_app.models.Payment;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;


@Component
public class PaymentMapper {

    public Payment toPayment(PaymentDTO paymentDTO, Order order) {
        if (paymentDTO == null || order == null) {
            return null;
        }
        Payment payment = new Payment();
        payment.setPaymentId(paymentDTO.paymentId());
        payment.setOrder(order);
        payment.setCurrency(paymentDTO.currency());
        payment.setAmount(paymentDTO.amount());
        payment.setPaymentDate(paymentDTO.paymentDate() != null ? paymentDTO.paymentDate() : LocalDate.now());
        payment.setPaymentStatus(paymentDTO.paymentStatus());

        return payment;
    }

    public PaymentDTO toPaymentDTO(Payment payment) {
        if (payment == null) {
            return null;
        }

        return new PaymentDTO(
                payment.getPaymentId(),
                payment.getOrder() != null ? payment.getOrder().getOrderId() : null,
                payment.getAmount(),
                payment.getCurrency(),
                payment.getPaymentDate(),
                payment.getPaymentStatus()
        );
    }
}
