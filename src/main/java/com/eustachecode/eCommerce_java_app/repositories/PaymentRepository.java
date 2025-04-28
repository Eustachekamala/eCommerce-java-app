package com.eustachecode.eCommerce_java_app.repositories;

import com.eustachecode.eCommerce_java_app.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
