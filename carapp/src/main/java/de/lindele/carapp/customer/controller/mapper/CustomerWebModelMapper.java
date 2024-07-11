package de.lindele.carapp.customer.controller.mapper;

import de.lindele.carapp.customer.controller.model.CustomerWebModel;
import de.lindele.carapp.customer.service.model.Customer;
import java.sql.Date;
import org.springframework.stereotype.Component;

// TODO test Mapping
@Component
public class CustomerWebModelMapper {

  //    private String firstname;
  //    private String lastname;
  //    private String address;
  //    private Date birthdate;
  //    private String city;
  //    private String postalCode;
  //    private String phoneNumber;
  //    private String email;

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

  public Customer map(CustomerWebModel customerWebModel) {
    Customer customer = new Customer();
    customer.setAddress(customerWebModel.getAddress());
    customer.setCity(customerWebModel.getCity());
    customer.setEmail(customerWebModel.getEmail());
    customer.setFirstname(customerWebModel.getFirstname());
    customer.setLastname(customerWebModel.getLastname());
    customer.setPhoneNumber(customerWebModel.getPhoneNumber());
    customer.setPostalCode(customerWebModel.getPostalCode());
    customer.setBirthdate(new Date(customerWebModel.getBirthdate().getTime()));
    return customer;
  }
}
