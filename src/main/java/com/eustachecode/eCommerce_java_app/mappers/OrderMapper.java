package com.eustachecode.eCommerce_java_app.mappers;

import com.eustachecode.eCommerce_java_app.dto.OrderDTO;
import com.eustachecode.eCommerce_java_app.models.Customer;
import com.eustachecode.eCommerce_java_app.models.Order;
import com.eustachecode.eCommerce_java_app.models.OrderItem;
import com.eustachecode.eCommerce_java_app.models.Product;
import com.eustachecode.eCommerce_java_app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class OrderMapper {

    @Autowired
    private ProductRepository productRepository;

    public Order toOrder(OrderDTO orderDto){
        Order order = new Order();
        order.setOrderId(orderDto.orderId());

        // Set Customer with just the ID
        if(orderDto.customerId() != null) {
            Customer customer = new Customer();
            customer.setCustomerId(orderDto.customerId());
            order.setCustomer(customer);
        }

        order.setOrderDate(orderDto.orderDate() != null ? orderDto.orderDate() : LocalDate.now());
        order.setTotalAmount(orderDto.totalAmount());

        // Map orderItems to OrderItem objects and set the Product using productId
        if(orderDto.orderItems() != null) {
            List<OrderItem> orderItems = new ArrayList<>();
            for(OrderDTO.OrderItemDTO orderItemDTO : orderDto.orderItems()) {
                OrderItem orderItem = new OrderItem();

                // Fetch product by productId
                Product product = productRepository.findById(orderItemDTO.productId())
                        .orElseThrow(() -> new RuntimeException("Product not found"));

                orderItem.setProduct(product);  // Set the product object
                orderItem.setQuantity(orderItemDTO.quantity());

                orderItems.add(orderItem);
            }
            order.setOrderItems(orderItems);
        } else {
            order.setOrderItems(new ArrayList<>());
        }

        return order;
    }

    public OrderDTO toOrderDTO(Order order){
        List<OrderDTO.OrderItemDTO> orderItemDTOs = new ArrayList<>();
        if (order.getOrderItems() != null) {
            for (OrderItem item : order.getOrderItems()) {
                if (item != null) {
                    // Map OrderItem to OrderItemDTO
                    orderItemDTOs.add(new OrderDTO.OrderItemDTO(item.getProduct().getProductId(), item.getQuantity()));
                }
            }
        }

        return new OrderDTO(
                order.getOrderId(),
                order.getCustomer() != null ? order.getCustomer().getCustomerId() : null,
                order.getOrderDate(),
                order.getTotalAmount(),
                orderItemDTOs
        );
    }
}
