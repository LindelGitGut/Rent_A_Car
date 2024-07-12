package de.lindele.carapp.customer.repository.mapper;

import de.lindele.carapp.customer.repository.model.CustomerEntity;
import de.lindele.carapp.customer.service.model.Customer;
import org.springframework.stereotype.Component;

// TODO check if works as suggested
@Component
public class CustomerEntityMapper {

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

//    CustomerEntity customerEntity = new CustomerEntity();
//    customerEntity.setAddress(customer.getAddress());
//    customerEntity.setBirthdate(customer.getBirthdate());
//    customerEntity.setId(customer.getId());
//    customerEntity.setEmail(customer.getEmail());
//    customerEntity.setPhoneNumber(customer.getPhoneNumber());
//    customerEntity.setFirstname(customer.getFirstname());
//    customerEntity.setLastname(customer.getLastname());
//    customerEntity.setPostalCode(customer.getPostalCode());
//    customerEntity.setCity(customer.getCity());
//    return customerEntity;
  }

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

    //    Customer customer = new Customer();
    //    customer.setId(customerEntity.getId());
    //    customer.setAddress(customerEntity.getAddress());
    //    customer.setCity(customerEntity.getCity());
    //    customer.setPostalCode(customerEntity.getPostalCode());
    //    customer.setBirthdate(customerEntity.getBirthdate());
    //    customer.setEmail(customerEntity.getEmail());
    //    customer.setPhoneNumber(customerEntity.getPhoneNumber());
    //    customer.setFirstname(customerEntity.getFirstname());
    //    customer.setLastname(customerEntity.getLastname());
    //    return customer;
  }
}
