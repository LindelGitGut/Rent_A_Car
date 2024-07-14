package de.lindele.carapp.customer.controller.mapper;

import de.lindele.carapp.customer.controller.model.request.UpdateCustomerRequest;
import de.lindele.carapp.customer.service.model.Customer;
import org.springframework.stereotype.Component;

/** Mapper class to map an UpdateCustomerRequest to a Customer. */
@Component
public class UpdateCustomerRequestMapper {

  /**
   * Maps an UpdateCustomerRequest to a Customer.
   *
   * @param updateCustomerRequest the request to map
   * @return the mapped Customer
   */
  public Customer map(UpdateCustomerRequest updateCustomerRequest) {
    return Customer.builder()
        .firstname(updateCustomerRequest.getFirstname())
        .lastname(updateCustomerRequest.getLastname())
        .address(updateCustomerRequest.getAddress())
        .birthdate(updateCustomerRequest.getBirthdate())
        .city(updateCustomerRequest.getCity())
        .postalCode(updateCustomerRequest.getPostalCode())
        .phoneNumber(updateCustomerRequest.getPhoneNumber())
        .email(updateCustomerRequest.getEmail())
        .build();
  }
}
