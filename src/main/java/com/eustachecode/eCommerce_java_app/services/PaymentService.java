package com.eustachecode.eCommerce_java_app.services;

import com.eustachecode.eCommerce_java_app.dto.PaymentDTO;
import com.eustachecode.eCommerce_java_app.mappers.PaymentMapper;
import com.eustachecode.eCommerce_java_app.models.Currency;
import com.eustachecode.eCommerce_java_app.models.Order;
import com.eustachecode.eCommerce_java_app.models.Payment;
import com.eustachecode.eCommerce_java_app.models.PaymentStatus;
import com.eustachecode.eCommerce_java_app.repositories.OrderRepository;
import com.eustachecode.eCommerce_java_app.repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final OrderRepository orderRepository;

    //Create new payment
    public PaymentDTO createPayment(Integer orderId, PaymentDTO paymentDTO) {
        //fetch the order
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        Payment payment = paymentMapper.toPayment(paymentDTO, order);
        if (payment.getPaymentStatus() == null) {
            payment.setPaymentStatus(PaymentStatus.PENDING);
        }
        Payment savedPayment = paymentRepository.save(payment);
        return paymentMapper.toPaymentDTO(savedPayment);
    }

    //Get all payments
    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll()
                .stream()
                .map(paymentMapper::toPaymentDTO)
                .collect(Collectors.toList());
    }

    //Confirm a pyment
    public PaymentDTO confirmPayment(Integer paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        payment.setPaymentStatus(PaymentStatus.COMPLETED);
        Payment updatedPayment = paymentRepository.save(payment);

        return paymentMapper.toPaymentDTO(updatedPayment);
    }

    // Cancel a payment
    public PaymentDTO cancelPayment(Integer paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        payment.setPaymentStatus(PaymentStatus.CANCELLED);
        Payment updatedPayment = paymentRepository.save(payment);

        return paymentMapper.toPaymentDTO(updatedPayment);
    }

    // Mark a payment as failed
    public PaymentDTO failPayment(Integer paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        payment.setPaymentStatus(PaymentStatus.FAILED);
        Payment updatedPayment = paymentRepository.save(payment);

        return paymentMapper.toPaymentDTO(updatedPayment);
    }

}
