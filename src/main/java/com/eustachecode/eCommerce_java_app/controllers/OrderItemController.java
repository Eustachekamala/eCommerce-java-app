package com.eustachecode.eCommerce_java_app.controllers;

import com.eustachecode.eCommerce_java_app.dto.OrderItemDTO;
import com.eustachecode.eCommerce_java_app.services.OrderItemService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "OrderItem Management", description = "Operations related to orderItems")
@RequiredArgsConstructor
@RequestMapping("/api/orderItems")
@RestController
public class OrderItemController {
    private final OrderItemService orderItemService;

    @PostMapping
    public ResponseEntity<OrderItemDTO> createOrderItem(@RequestBody OrderItemDTO orderItem) {
        return new ResponseEntity<>(orderItemService.create(orderItem), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrderItemDTO>> getAllOrderItems() {
        return new ResponseEntity<>(orderItemService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemDTO> getOrderItemById(@PathVariable Integer id) {
        return new ResponseEntity<>(orderItemService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItemDTO> updateOrderItem(@PathVariable Integer id, @RequestBody OrderItemDTO orderItem) {
        return new ResponseEntity<>(orderItemService.update(id, orderItem), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrderItem(@PathVariable Integer id) {
        orderItemService.delete(id);
        return new ResponseEntity<>("Order item deleted", HttpStatus.OK);
    }
}
