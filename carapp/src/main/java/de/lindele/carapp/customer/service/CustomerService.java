package de.lindele.carapp.customer.service;


import de.lindele.carapp.customer.service.model.Customer;
import de.lindele.carapp.customer.service.port.CustomerPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {


    @Autowired
    CustomerPersistencePort customerPersistencePort;

    public Customer createCustomer(Customer customer) {
        return customerPersistencePort.saveCustomer(customer);
    }

    public Customer updateCustomer(Customer customer, Long id) {
        customer.setId(id);
        return customerPersistencePort.updateCustomer(customer);
    }

    public void deleteCustomer(Long id) {
        customerPersistencePort.deleteCustomer(id);
    }

    public Customer getCustomer(Long id) {
        return customerPersistencePort.findCustomerById(id);
    }

    public Page<Customer> getAllCustomers(Pageable pageable) {
        return customerPersistencePort.findAllCustomer(pageable);
    }

    public Page<Customer> getAllCustomersByFirstName(String firstname, Pageable pageable) {
        return customerPersistencePort.findAllCustomerByFirstName(firstname, pageable);
    }

    public Page<Customer> getAllCustomersByLastName(String lastname, Pageable pageable) {
        return customerPersistencePort.findAllCustomerByFirstName(lastname, pageable);
    }

    public Page<Customer> getAllCustomersByFirstNameAndLastName(String firstname, String lastname, Pageable pageable) {
        return customerPersistencePort.findAllCustomerByFirstNameAndLastName(firstname, lastname, pageable);
    }

}
