package com.eustachecode.eCommerce_java_app.services;

import com.eustachecode.eCommerce_java_app.dto.OrderItemDTO;
import com.eustachecode.eCommerce_java_app.errors.ResourceNotFoundException;
import com.eustachecode.eCommerce_java_app.mappers.OrderItemMapper;
import com.eustachecode.eCommerce_java_app.models.OrderItem;
import com.eustachecode.eCommerce_java_app.repositories.OrderItemRepository;
import com.eustachecode.eCommerce_java_app.repositories.OrderRepository;
import com.eustachecode.eCommerce_java_app.repositories.ProductRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderItemService {
    private final OrderItemRepository repository;
    private final OrderItemMapper mapper;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    //Create an OrderItem
    @Operation(summary = "Create a new OrderItem")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OrderItem created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public OrderItemDTO create(OrderItemDTO dto) {
        OrderItem orderItem = mapper.toOrderItem(dto);
        OrderItem orderItemSaved = repository.save(orderItem);
        return mapper.toOrderItemDTO(orderItemSaved);
    }

    //Get All OrderItems
    public List<OrderItemDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toOrderItemDTO)
                .collect(Collectors.toList());
    }

    //Get by id
    public OrderItemDTO findById(Integer id) {
        return repository.findById(id)
                .map(mapper::toOrderItemDTO)
                .orElseThrow(() -> new ResourceNotFoundException("OrderItem with id: " +id + " not found"));
    }

    //Update
    @Operation(summary = "Update OrderItem")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "OrderItem updated successfully"),
            @ApiResponse(responseCode = "404", description = "Invalid id")
    })
    public OrderItemDTO update(Integer id, OrderItemDTO dto) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id: " +id + " not found"));
        var order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order with id: " +id + " not found"));
        OrderItem orderItem = mapper.toOrderItem(dto);
        orderItem.setOrderItemId(dto.orderItemId());
        orderItem.setProduct(product);
        orderItem.setOrder(order);
        orderItem.setQuantity(dto.quantity());
        OrderItem orderItemSaved = repository.save(orderItem);
        return mapper.toOrderItemDTO(orderItemSaved);

    }

    //Delete an OrderItem
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
