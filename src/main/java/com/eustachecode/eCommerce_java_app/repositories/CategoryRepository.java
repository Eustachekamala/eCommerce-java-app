package com.eustachecode.eCommerce_java_app.repositories;

import com.eustachecode.eCommerce_java_app.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
