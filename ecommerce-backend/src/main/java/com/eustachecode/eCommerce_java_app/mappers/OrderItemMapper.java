package com.eustachecode.eCommerce_java_app.mappers;

import com.eustachecode.eCommerce_java_app.dto.OrderItemDTO;
import com.eustachecode.eCommerce_java_app.models.Order;
import com.eustachecode.eCommerce_java_app.models.OrderItem;
import com.eustachecode.eCommerce_java_app.models.Product;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {
    public OrderItem toOrderItem(OrderItemDTO dto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderItemId(dto.orderItemId());

        // Set Order with just ID
        if (dto.orderId() != null) {
            Order order = new Order();
            order.setOrderId(dto.orderId());
            orderItem.setOrder(order);
        }

        orderItem.setQuantity(dto.quantity());

        // Map ProductID to Product object
        if (dto.productId() != null) {
            Product product = new Product();
            product.setProductId(dto.productId());
            orderItem.setProduct(product);
        }

        return orderItem;
    }

    public OrderItemDTO toOrderItemDTO(OrderItem orderItem) {
        return new OrderItemDTO(
                orderItem.getOrderItemId(),
                orderItem.getOrder() != null ? orderItem.getOrder().getOrderId() : null,
                orderItem.getProduct() != null ? orderItem.getProduct().getProductId() : null,
                orderItem.getQuantity()
        );
    }
}
