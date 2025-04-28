package com.eustachecode.eCommerce_java_app.mappers;

import com.eustachecode.eCommerce_java_app.dto.ProductDTO;
import com.eustachecode.eCommerce_java_app.models.OrderItem;
import com.eustachecode.eCommerce_java_app.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ProductMapper {
    public Product toProduct(ProductDTO dto){
       Product product = new Product();
       product.setProductId(dto.productId());
       product.setProductName(dto.productName());
       product.setStock(dto.stock());
       product.setPrice(dto.price());
       return product;
    }
    public ProductDTO toProductDTO(Product product){
        return new ProductDTO(
                product.getProductId(),
                product.getProductName(),
                product.getStock(),
                product.getPrice(),
                product.getCategory() != null ? product.getCategory().getCategoryId() : null,
                new ArrayList<>()
        );
    }
}
