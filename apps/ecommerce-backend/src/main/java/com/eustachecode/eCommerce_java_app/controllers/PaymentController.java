package com.eustachecode.eCommerce_java_app.controllers;

import com.eustachecode.eCommerce_java_app.dto.PaymentDTO;
import com.eustachecode.eCommerce_java_app.services.PaymentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Payment Management", description = "Operations related to products payment")
@RequiredArgsConstructor
@RequestMapping("/api/orders/payment")
@RestController
public class PaymentController {
    private final PaymentService paymentService;

    // 1️ Create a new Payment for an Order
    @PostMapping("/{orderId}")
    public PaymentDTO createPayment(@PathVariable Integer orderId, @RequestBody PaymentDTO paymentDTO) {
        return paymentService.createPayment(orderId, paymentDTO);
    }

    //Get all payments
    @GetMapping
    public List<PaymentDTO> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // 2️Confirm a Payment
    @PostMapping("/confirm/{paymentId}")
    public PaymentDTO confirmPayment(@PathVariable Integer paymentId) {
        return paymentService.confirmPayment(paymentId);
    }

    // 3️ Cancel a Payment
    @PostMapping("/cancel/{paymentId}")
    public PaymentDTO cancelPayment(@PathVariable Integer paymentId) {
        return paymentService.cancelPayment(paymentId);
    }

    // 4️ Mark a Payment as Failed
    @PostMapping("/fail/{paymentId}")
    public PaymentDTO failPayment(@PathVariable Integer paymentId) {
        return paymentService.failPayment(paymentId);
    }
}
