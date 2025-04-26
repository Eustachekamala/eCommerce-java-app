package com.eustachecode.eCommerce_java_app.mappers;

import com.eustachecode.eCommerce_java_app.dto.OrderDTO;
import com.eustachecode.eCommerce_java_app.dto.OrderItemDTO;
import com.eustachecode.eCommerce_java_app.models.OrderItem;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-26T19:45:48+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Ubuntu)"
)
@Component
public class OrderItemMapperImpl implements OrderItemMapper {

    @Override
    public OrderItem toOrderItem(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        OrderItem orderItem = new OrderItem();

        return orderItem;
    }

    @Override
    public OrderItemDTO toOrderItemDTO(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        Integer orderItemId = null;
        int quantity = 0;

        orderItemId = orderItem.getOrderItemId();
        quantity = orderItem.getQuantity();

        Integer orderId = null;
        Integer productId = null;

        OrderItemDTO orderItemDTO = new OrderItemDTO( orderItemId, orderId, productId, quantity );

        return orderItemDTO;
    }
}
