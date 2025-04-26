package com.eustachecode.eCommerce_java_app.mappers;

import com.eustachecode.eCommerce_java_app.dto.CategoryDTO;
import com.eustachecode.eCommerce_java_app.models.Category;
import com.eustachecode.eCommerce_java_app.models.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toCategory(CategoryDTO categoryDTO);
    CategoryDTO toCategoryDTO(Category category);

    default Product map(Integer productId){
        if(productId == null) return null;
        Product product = new Product();
        product.setProductId(productId);
        return product;
    }

    default Integer map(Product product) {
        if (product == null) {
            return null;
        }
        return product.getProductId();
    }
}
