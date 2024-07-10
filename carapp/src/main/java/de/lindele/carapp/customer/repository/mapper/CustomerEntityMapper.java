package de.lindele.carapp.customer.repository.mapper;


import de.lindele.carapp.customer.repository.model.CustomerEntity;
import de.lindele.carapp.customer.service.model.Customer;
import org.springframework.stereotype.Component;

//TODO check if works as suggested
@Component
public class CustomerEntityMapper {



    public CustomerEntity map (Customer customer){
        CustomerEntity customerEntity = new CustomerEntity();
      customerEntity.setAddress(customer.getAddress());
      customerEntity.setBirthdate(customer.getBirthdate());
      customerEntity.setId(customer.getId());
      customerEntity.setEmail(customer.getEmail());
      customerEntity.setPhoneNumber(customer.getPhoneNumber());
      customerEntity.setFirstname(customer.getFirstname());
        customerEntity.setLastname(customer.getLastname());
        customerEntity.setPostalCode(customer.getPostalCode());
        customerEntity.setCity(customer.getCity());
        return customerEntity;
    }


    public Customer map (CustomerEntity customerEntity){
        Customer customer = new Customer();
        customer.setId(customerEntity.getId());
        customer.setAddress(customerEntity.getAddress());
        customer.setCity(customerEntity.getCity());
        customer.setPostalCode(customerEntity.getPostalCode());
        customer.setBirthdate(customerEntity.getBirthdate());
        customer.setEmail(customerEntity.getEmail());
        customer.setPhoneNumber(customerEntity.getPhoneNumber());
        customer.setFirstname(customerEntity.getFirstname());
        customer.setLastname(customerEntity.getLastname());
        return customer;
    }



}
