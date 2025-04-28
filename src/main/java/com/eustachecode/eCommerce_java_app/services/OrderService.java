package com.eustachecode.eCommerce_java_app.services;

import com.eustachecode.eCommerce_java_app.dto.OrderDTO;
import com.eustachecode.eCommerce_java_app.errors.ResourceNotFoundException;
import com.eustachecode.eCommerce_java_app.mappers.OrderMapper;
import com.eustachecode.eCommerce_java_app.models.Order;
import com.eustachecode.eCommerce_java_app.repositories.CustomerRepository;
import com.eustachecode.eCommerce_java_app.repositories.OrderRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final CustomerRepository customerRepository;

    //Create an order
    @Operation(summary = "Create a new Order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public OrderDTO createOrder(OrderDTO orderDTO) {
        //Convert to DTO
        Order order = orderMapper.toOrder(orderDTO);
        //Set up the relationship
        order.setOrderItems(order.getOrderItems());
        //Save the order
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toOrderDTO(savedOrder);
    }

    //Get all Orders
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toOrderDTO)
                .collect(Collectors.toList());
    }

    //Get order by id
    public OrderDTO getOrderById(Integer id) {
        return orderRepository.findById(id)
                .map(orderMapper::toOrderDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Order with id: " +id+ " not found"));
    }

    //Update an Order
    @Operation(summary = "Update Order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Order updated successfully"),
            @ApiResponse(responseCode = "404", description = "Invalid id")
    })
    public OrderDTO updateOrder(Integer id, OrderDTO orderDTO) {
        var customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id: " +id + " not found"));

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order with id: " +id + " not found"));
        order.setCustomer(customer);
        order.setOrderDate(orderDTO.orderDate());
        order.setTotalAmount(orderDTO.totalAmount());
        return orderMapper.toOrderDTO(orderRepository.save(order));
    }

    //Delete an Order
    public void deleteOrderById(Integer id) {
        orderRepository.deleteById(id);
    }
}
