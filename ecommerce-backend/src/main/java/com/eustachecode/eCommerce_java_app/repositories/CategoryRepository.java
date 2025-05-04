package com.eustachecode.eCommerce_java_app.repositories;

import com.eustachecode.eCommerce_java_app.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByCategoryName(Category categoryName);
}
