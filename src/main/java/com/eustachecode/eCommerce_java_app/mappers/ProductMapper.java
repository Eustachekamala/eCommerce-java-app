package com.eustachecode.eCommerce_java_app.mappers;

import com.eustachecode.eCommerce_java_app.dto.ProductDTO;
import com.eustachecode.eCommerce_java_app.models.OrderItem;
import com.eustachecode.eCommerce_java_app.models.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductDTO dto);
    ProductDTO toProductDTO(Product product);

    default OrderItem map(Integer id) {
        if (id == null) {
            return null;
        }
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderItemId(id);
        return orderItem;
    }

    default Integer map(OrderItem orderItem) {
        if (orderItem == null) {
            return null;
        }
        return orderItem.getOrderItemId();
    }
}
