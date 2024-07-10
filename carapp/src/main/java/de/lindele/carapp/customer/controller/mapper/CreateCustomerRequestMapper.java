package de.lindele.carapp.customer.controller.mapper;

import de.lindele.carapp.customer.controller.model.request.CreateCustomerRequest;
import de.lindele.carapp.customer.service.model.Customer;
import org.springframework.stereotype.Component;


@Component
public class CreateCustomerRequestMapper {

    //   private Long id;
    //    private String firstname;
    //    private String lastname;
    //    private String address;
    //    private Date birthdate;
    //    private String city;
    //    private String postalCode;
    //    private String phoneNumber;
    //    private String email;
    public Customer map(CreateCustomerRequest createCustomerRequest) {
        Customer customer= new Customer();
        customer.setFirstname(createCustomerRequest.getFirstname());
        customer.setLastname(createCustomerRequest.getLastname());
        customer.setAddress(createCustomerRequest.getAddress());
        customer.setBirthdate(createCustomerRequest.getBirthdate());
        customer.setCity(createCustomerRequest.getCity());
        customer.setPostalCode(createCustomerRequest.getPostalCode());
        customer.setPhoneNumber(createCustomerRequest.getPhoneNumber());
        customer.setEmail(createCustomerRequest.getEmail());
        return customer;
    }


    //TODO check if conversion in both direction is needed
}
