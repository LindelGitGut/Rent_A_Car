package de.lindele.carapp.customer.service.port;


import de.lindele.carapp.customer.service.model.Customer;

public interface CustomerPersistencePort {



    Customer findCustomerById(Long id);

    Customer saveCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    void deleteCustomer(Long id);

    Customer findCustomerByFirstName(String firstName);

    Customer findCustomerByLastName(String lastName);

    Customer findCustomerByFirstNameAndLastName(String firstName, String lastName);



}
