package com.eustachecode.eCommerce_java_app.mappers;

import com.eustachecode.eCommerce_java_app.dto.OrderDTO;
import com.eustachecode.eCommerce_java_app.models.Order;
import com.eustachecode.eCommerce_java_app.models.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order toOrder(OrderDTO orderDto);
    OrderDTO toOrderDTO(Order order);

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
