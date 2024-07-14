package de.lindele.carapp.customer.repository.mapper;

import de.lindele.carapp.customer.repository.model.CustomerEntity;
import de.lindele.carapp.customer.service.model.Customer;
import org.springframework.stereotype.Component;

/** Mapper for the customer entity. */
@Component
public class CustomerEntityMapper {

  /**
   * Maps a customer to a customer entity.
   *
   * @param customer The customer to map.
   * @return The mapped customer entity.
   */
  public CustomerEntity map(Customer customer) {

    return CustomerEntity.builder()
        .id(customer.getId())
        .firstname(customer.getFirstname())
        .lastname(customer.getLastname())
        .address(customer.getAddress())
        .city(customer.getCity())
        .postalCode(customer.getPostalCode())
        .birthdate(customer.getBirthdate())
        .email(customer.getEmail())
        .phoneNumber(customer.getPhoneNumber())
        .build();
  }

  /**
   * Maps a customer entity to a customer.
   *
   * @param customerEntity The customer entity to map.
   * @return The mapped customer.
   */
  public Customer map(CustomerEntity customerEntity) {

    return Customer.builder()
        .id(customerEntity.getId())
        .address(customerEntity.getAddress())
        .city(customerEntity.getCity())
        .postalCode(customerEntity.getPostalCode())
        .birthdate(customerEntity.getBirthdate())
        .email(customerEntity.getEmail())
        .phoneNumber(customerEntity.getPhoneNumber())
        .firstname(customerEntity.getFirstname())
        .lastname(customerEntity.getLastname())
        .build();
  }
}
