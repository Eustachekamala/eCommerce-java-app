package com.eustachecode.eCommerce_java_app.mappers;

import com.eustachecode.eCommerce_java_app.dto.CustomerDTO;
import com.eustachecode.eCommerce_java_app.models.Customer;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-26T19:45:47+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Ubuntu)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toCustomer(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setCustomerId( customerDTO.customerId() );
        customer.setName( customerDTO.name() );
        customer.setEmail( customerDTO.email() );
        customer.setPassword( customerDTO.password() );
        customer.setAddress( customerDTO.address() );

        return customer;
    }

    @Override
    public CustomerDTO toCustomerDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        Integer customerId = null;
        String name = null;
        String email = null;
        String password = null;
        String address = null;

        customerId = customer.getCustomerId();
        name = customer.getName();
        email = customer.getEmail();
        password = customer.getPassword();
        address = customer.getAddress();

        List<Integer> orderIds = null;

        CustomerDTO customerDTO = new CustomerDTO( customerId, name, email, password, address, orderIds );

        return customerDTO;
    }
}
