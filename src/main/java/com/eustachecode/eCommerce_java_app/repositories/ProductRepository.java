package com.eustachecode.eCommerce_java_app.repositories;

import com.eustachecode.eCommerce_java_app.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
