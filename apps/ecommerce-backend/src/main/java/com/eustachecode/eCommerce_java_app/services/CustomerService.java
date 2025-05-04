package com.eustachecode.eCommerce_java_app.services;

import com.eustachecode.eCommerce_java_app.dto.CustomerDTO;
import com.eustachecode.eCommerce_java_app.errors.ResourceNotFoundException;
import com.eustachecode.eCommerce_java_app.mappers.CustomerMapper;
import com.eustachecode.eCommerce_java_app.models.Customer;
import com.eustachecode.eCommerce_java_app.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.toCustomer(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.toCustomerDTO(savedCustomer);
    }

    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toCustomerDTO)
                .collect(Collectors.toList());
    }

    public CustomerDTO getCustomerById(Integer id) {
        return customerRepository.findById(id)
                .map(customerMapper::toCustomerDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id: " +id+ " not found"));
    }

    public CustomerDTO updateCustomer(Integer id, CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id: " +id+ " not found"));
        customer.setName(customerDTO.name());
        customer.setEmail(customerDTO.email());
        customer.setPassword(customerDTO.password());
        customer.setAddress(customerDTO.address());

        return customerMapper.toCustomerDTO(customerRepository.save(customer));
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}
