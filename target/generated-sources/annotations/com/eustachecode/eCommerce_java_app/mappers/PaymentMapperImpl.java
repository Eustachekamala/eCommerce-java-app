package com.eustachecode.eCommerce_java_app.mappers;

import com.eustachecode.eCommerce_java_app.dto.PaymentDTO;
import com.eustachecode.eCommerce_java_app.models.Order;
import com.eustachecode.eCommerce_java_app.models.Payment;
import java.util.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-27T01:56:38+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Ubuntu)"
)
@Component
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public Payment toPayment(PaymentDTO paymentDTO) {
        if ( paymentDTO == null ) {
            return null;
        }

        Payment payment = new Payment();

        payment.setPaymentId( paymentDTO.paymentId() );
        payment.setAmount( paymentDTO.amount() );
        payment.setOrder( paymentDTO.order() );
        payment.setPaymentDate( paymentDTO.paymentDate() );
        payment.setPaymentStatus( paymentDTO.paymentStatus() );

        return payment;
    }

    @Override
    public PaymentDTO toPaymentDTO(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        Integer paymentId = null;
        Order order = null;
        double amount = 0.0d;
        Date paymentDate = null;
        String paymentStatus = null;

        paymentId = payment.getPaymentId();
        order = payment.getOrder();
        amount = payment.getAmount();
        paymentDate = payment.getPaymentDate();
        paymentStatus = payment.getPaymentStatus();

        PaymentDTO paymentDTO = new PaymentDTO( paymentId, order, amount, paymentDate, paymentStatus );

        return paymentDTO;
    }
}
