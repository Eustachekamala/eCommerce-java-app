package com.eustachecode.eCommerce_java_app.mappers;

import com.eustachecode.eCommerce_java_app.dto.CategoryDTO;
import com.eustachecode.eCommerce_java_app.models.Category;
import com.eustachecode.eCommerce_java_app.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapper {
    public Category toCategory(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setCategoryId(categoryDTO.categoryId());
        category.setCategoryName(categoryDTO.categoryName());
        category.setDescription(categoryDTO.description());
        //Convert List<Integer> product IDs to List<Product> objects
        if(categoryDTO.products() != null) {
            List<Product> products = new ArrayList<>();
            for( Integer productId : categoryDTO.products()) {
                Product product = new Product();
                product.setProductId(productId);
                products.add(product);
            }
            category.setProducts(products);
        } else {
            category.setProducts(new ArrayList<>());
        }
        return category;
    }
    public CategoryDTO toCategoryDTO(Category category){
        List<Integer> productIds = new ArrayList<>();
        if (category.getProducts() != null) {
            for (Product product : category.getProducts()) {
                if (product != null) {
                    productIds.add(product.getProductId());
                }
            }
        }
        return new CategoryDTO(
                category.getCategoryId(),
                category.getCategoryName(),
                category.getDescription(),
                productIds
        );
    }
}
