package com.eustachecode.eCommerce_java_app.mappers;

import com.eustachecode.eCommerce_java_app.dto.CustomerDTO;
import com.eustachecode.eCommerce_java_app.models.Customer;
import com.eustachecode.eCommerce_java_app.models.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper {
    public Customer toCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setCustomerId(customerDTO.customerId());
        customer.setName(customerDTO.name());
        customer.setEmail(customerDTO.email());
        customer.setPassword(customerDTO.password());

        //Map OrderIds to Order object
        if (customerDTO.orderIds() != null) {
            List<Order> orders = new ArrayList<>();
            for (Integer orderId : customerDTO.orderIds()) {
                Order order = new Order();
                order.setOrderId(orderId);
                orders.add(order);
            }
            customer.setOrders(orders);
        } else {
            customer.setOrders(new ArrayList<>());
        }

        customer.setAddress(customerDTO.address());
        return customer;
    }
    public CustomerDTO toCustomerDTO(Customer customer){
        List<Integer> orders = new ArrayList<>();
        if (customer.getOrders() != null) {
            for (Order order : customer.getOrders()) {
                if (order.getOrderId() != null) {
                    orders.add(order.getOrderId());
                }
            }
        }
        return new CustomerDTO(
                customer.getCustomerId(),
                customer.getName(),
                customer.getEmail(),
                customer.getAddress(),
                customer.getPassword(),
                orders
        );
    }
}
