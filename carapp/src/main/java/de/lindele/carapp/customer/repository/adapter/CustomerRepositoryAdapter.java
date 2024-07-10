package de.lindele.carapp.customer.repository.adapter;

import de.lindele.carapp.customer.repository.mapper.CustomerEntityMapper;
import de.lindele.carapp.customer.repository.model.CustomerEntity;
import de.lindele.carapp.customer.service.model.Customer;
import de.lindele.carapp.customer.service.port.CustomerPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CustomerRepositoryAdapter implements CustomerPersistencePort {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;


    @Override
    public Customer findCustomerById(Long id) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        if (customerEntity.isPresent()){

            return customerEntityMapper.map(customerEntity.get());
        } else {
            return null;
        }


    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {

    }

    @Override
    public Customer findCustomerByFirstName(String firstName) {
        return null;
    }

    @Override
    public Customer findCustomerByLastName(String lastName) {
        return null;
    }

    @Override
    public Customer findCustomerByFirstNameAndLastName(String firstName, String lastName) {
        return null;
    }
}
