package de.lindele.carapp.customer.repository.adapter;

import de.lindele.carapp.customer.repository.mapper.CustomerEntityMapper;
import de.lindele.carapp.customer.repository.model.CustomerEntity;
import de.lindele.carapp.customer.service.model.Customer;
import de.lindele.carapp.customer.service.port.CustomerPersistencePort;
import de.lindele.carapp.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
            throw new ResourceNotFoundException("Customer not found with id: " + id);
        }
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.map(customer);
        return customerEntityMapper.map(customerRepository.save(customerEntity));
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(customer.getId());
        if (customerEntity.isPresent()){
            CustomerEntity updatedCustomerEntity = customerEntityMapper.map(customer);
            return customerEntityMapper.map(customerRepository.save(updatedCustomerEntity));
        } else {
            throw new ResourceNotFoundException("Customer not found with id: " + customer.getId());
        }
    }

    @Override
    public void deleteCustomer(Long id) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        if (customerEntity.isPresent()){
            customerRepository.delete(customerEntity.get());
        } else {
            throw new ResourceNotFoundException("Customer not found with id: " + id);
        }
    }

    @Override
    public Page<Customer> findAllCustomer(Pageable pageable) {
        Page<CustomerEntity> customers = customerRepository.findAll(pageable);
        return customers.map(customerEntityMapper::map);
    }


    @Override
    public Page<Customer> findAllCustomerByFirstName(String firstName, Pageable pageable) {
        Page<CustomerEntity> customers = customerRepository.findByFirstName(firstName, pageable);
        return customers.map(customerEntityMapper::map);
    }

    @Override
    public Page<Customer> findAllCustomerByLastName(String lastName, Pageable pageable) {
        Page<CustomerEntity> customers = customerRepository.findByLastName(lastName, pageable);
        return customers.map(customerEntityMapper::map);
    }

    @Override
    public Page<Customer> findAllCustomerByFirstNameAndLastName(String firstName, String lastName, Pageable pageable) {
        Page<CustomerEntity> customers = customerRepository.findByFirstNameAndLastName(firstName, lastName, pageable);
               return customers.map(customerEntityMapper::map);
    }

}
