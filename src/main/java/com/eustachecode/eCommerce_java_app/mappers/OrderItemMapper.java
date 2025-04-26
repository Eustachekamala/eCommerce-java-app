package com.eustachecode.eCommerce_java_app.mappers;

import com.eustachecode.eCommerce_java_app.dto.OrderDTO;
import com.eustachecode.eCommerce_java_app.dto.OrderItemDTO;
import com.eustachecode.eCommerce_java_app.models.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItem toOrderItem(OrderDTO orderDTO);
    OrderItemDTO toOrderItemDTO(OrderItem orderItem);
}
