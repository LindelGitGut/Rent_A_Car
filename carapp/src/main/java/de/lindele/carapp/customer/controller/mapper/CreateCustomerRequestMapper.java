package de.lindele.carapp.customer.controller.mapper;

import de.lindele.carapp.customer.controller.model.request.CreateCustomerRequest;
import de.lindele.carapp.customer.service.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CreateCustomerRequestMapper {

  public Customer map(CreateCustomerRequest createCustomerRequest) {

    return Customer.builder()
        .firstname(createCustomerRequest.getFirstname())
        .lastname(createCustomerRequest.getLastname())
        .address(createCustomerRequest.getAddress())
        .birthdate(createCustomerRequest.getBirthdate())
        .city(createCustomerRequest.getCity())
        .postalCode(createCustomerRequest.getPostalCode())
        .phoneNumber(createCustomerRequest.getPhoneNumber())
        .email(createCustomerRequest.getEmail())
        .build();


  }

  // TODO check if conversion in both direction is needed
}
