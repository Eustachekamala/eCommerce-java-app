package com.eustachecode.eCommerce_java_app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    @Column(nullable = false)
    private double amount;
    @ManyToOne
    @JoinColumn(name = "oder_id", nullable = false)
    private Order order;
    private String currency;
    private Date paymentDate;
    @Column(nullable = false)
    private String paymentStatus;
}
