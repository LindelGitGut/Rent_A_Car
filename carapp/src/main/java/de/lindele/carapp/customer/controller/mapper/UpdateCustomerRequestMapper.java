package de.lindele.carapp.customer.controller.mapper;

import de.lindele.carapp.customer.controller.model.request.UpdateCustomerRequest;
import de.lindele.carapp.customer.service.model.Customer;
import org.springframework.stereotype.Component;

// TODO implement
@Component
public class UpdateCustomerRequestMapper {

  public Customer map(UpdateCustomerRequest updateCustomerRequest) {
    Customer customer = new Customer();
    customer.setFirstname(updateCustomerRequest.getFirstname());
    customer.setLastname(updateCustomerRequest.getLastname());
    customer.setAddress(updateCustomerRequest.getAddress());
    customer.setBirthdate(updateCustomerRequest.getBirthdate());
    customer.setCity(updateCustomerRequest.getCity());
    customer.setPostalCode(updateCustomerRequest.getPostalCode());
    customer.setPhoneNumber(updateCustomerRequest.getPhoneNumber());
    customer.setEmail(updateCustomerRequest.getEmail());
    return customer;
  }
}
