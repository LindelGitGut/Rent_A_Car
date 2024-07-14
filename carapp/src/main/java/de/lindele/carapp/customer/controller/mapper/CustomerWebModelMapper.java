package de.lindele.carapp.customer.controller.mapper;

import de.lindele.carapp.customer.controller.model.CustomerWebModel;
import de.lindele.carapp.customer.service.model.Customer;
import java.sql.Date;
import org.springframework.stereotype.Component;

/** Mapper class to map a Customer to a CustomerWebModel. */
@Component
public class CustomerWebModelMapper {

  /**
   * Maps a Customer to a CustomerWebModel.
   *
   * @param customer the customer to map
   * @return the mapped CustomerWebModel
   */
  public CustomerWebModel map(Customer customer) {
    CustomerWebModel customerWebModel = new CustomerWebModel();
    customerWebModel.setAddress(customer.getAddress());
    customerWebModel.setCity(customer.getCity());
    customerWebModel.setEmail(customer.getEmail());
    customerWebModel.setFirstname(customer.getFirstname());
    customerWebModel.setLastname(customer.getLastname());
    customerWebModel.setPhoneNumber(customer.getPhoneNumber());
    customerWebModel.setPostalCode(customer.getPostalCode());
    customerWebModel.setBirthdate(new Date(customer.getBirthdate().getTime()));
    return customerWebModel;
  }

  /**
   * Maps a CustomerWebModel to a Customer.
   *
   * @param customerWebModel the customer to map
   * @return the mapped Customer
   */
  public Customer map(CustomerWebModel customerWebModel) {

    return Customer.builder()
        .address(customerWebModel.getAddress())
        .city(customerWebModel.getCity())
        .email(customerWebModel.getEmail())
        .firstname(customerWebModel.getFirstname())
        .lastname(customerWebModel.getLastname())
        .phoneNumber(customerWebModel.getPhoneNumber())
        .postalCode(customerWebModel.getPostalCode())
        .birthdate(new Date(customerWebModel.getBirthdate().getTime()))
        .build();
  }
}
