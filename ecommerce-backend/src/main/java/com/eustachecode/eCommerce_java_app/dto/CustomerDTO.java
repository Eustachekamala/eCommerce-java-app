package com.eustachecode.eCommerce_java_app.dto;


import java.util.List;

public record CustomerDTO(
        Integer customerId,
        String name,
        String email,
        String password,
        String address,
        List<Integer> orderIds
) {
}
