package com.eustachecode.eCommerce_java_app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    @Column(precision = 10, scale = 2)
    private BigDecimal amount;
    @ManyToOne
    @JoinColumn(name = "oder_id", nullable = false)
    private Order order;
    @Convert(converter = CurrencyConverter.class)
    private Currency currency;
    private LocalDate paymentDate;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
}
