package de.lindele.carapp.customer.repository.adapter;

import de.lindele.carapp.customer.repository.mapper.CustomerEntityMapper;
import de.lindele.carapp.customer.repository.model.CustomerEntity;
import de.lindele.carapp.customer.service.model.Customer;
import de.lindele.carapp.customer.service.port.CustomerPersistencePort;
import de.lindele.carapp.exception.ResourceNotFoundException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/** Adapter for the customer repository. */
@Repository
@RequiredArgsConstructor
public class CustomerRepositoryAdapter implements CustomerPersistencePort {

  private final CustomerRepository customerRepository;
  private final CustomerEntityMapper customerEntityMapper;

  /**
   * Finds a customer by id.
   *
   * @param id The id of the customer.
   * @return The found customer.
   */
  @Override
  public Customer findCustomerById(Long id) {
    Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
    if (customerEntity.isPresent()) {
      return customerEntityMapper.map(customerEntity.get());
    } else {
      throw new ResourceNotFoundException("Customer not found with id: " + id);
    }
  }

  /**
   * Saves a customer.
   *
   * @param customer The customer to save.
   * @return The saved customer.
   */
  @Override
  public Customer saveCustomer(Customer customer) {
    CustomerEntity customerEntity = customerEntityMapper.map(customer);
    return customerEntityMapper.map(customerRepository.save(customerEntity));
  }

  /**
   * Updates a customer.
   *
   * @param customer The customer to update.
   * @return The updated customer.
   */
  @Override
  public Customer updateCustomer(Customer customer) {
    Optional<CustomerEntity> customerEntity = customerRepository.findById(customer.getId());
    if (customerEntity.isPresent()) {
      CustomerEntity updatedCustomerEntity = customerEntityMapper.map(customer);
      return customerEntityMapper.map(customerRepository.save(updatedCustomerEntity));
    } else {
      throw new ResourceNotFoundException("Customer not found with id: " + customer.getId());
    }
  }

  /**
   * Deletes a customer.
   *
   * @param id The id of the customer.
   */
  @Override
  public void deleteCustomer(Long id) {
    Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
    if (customerEntity.isPresent()) {
      customerRepository.delete(customerEntity.get());
    } else {
      throw new ResourceNotFoundException("Customer not found with id: " + id);
    }
  }

  /**
   * Gets all customers.
   *
   * @param pageable The pageable object.
   * @return The customers.
   */
  @Override
  public Page<Customer> findAllCustomer(Pageable pageable) {
    Page<CustomerEntity> customers = customerRepository.findAll(pageable);
    return customers.map(customerEntityMapper::map);
  }

  /**
   * Gets all customers by first name.
   *
   * @param firstName The first name of the customer.
   * @param pageable The pageable object.
   * @return The customers.
   */
  @Override
  public Page<Customer> findAllCustomerByFirstName(String firstName, Pageable pageable) {
    Page<CustomerEntity> customers = customerRepository.findByFirstname(firstName, pageable);
    return customers.map(customerEntityMapper::map);
  }

  /**
   * Gets all customers by last name.
   *
   * @param lastName The last name of the customer.
   * @param pageable The pageable object.
   * @return The customers.
   */
  @Override
  public Page<Customer> findAllCustomerByLastName(String lastName, Pageable pageable) {
    Page<CustomerEntity> customers = customerRepository.findByLastname(lastName, pageable);
    return customers.map(customerEntityMapper::map);
  }

  /**
   * Gets all customers by first name and last name.
   *
   * @param firstName The first name of the customer.
   * @param lastName The last name of the customer.
   * @param pageable The pageable object.
   * @return The customers.
   */
  @Override
  public Page<Customer> findAllCustomerByFirstNameAndLastName(
      String firstName, String lastName, Pageable pageable) {
    Page<CustomerEntity> customers =
        customerRepository.findByFirstnameAndLastname(firstName, lastName, pageable);
    return customers.map(customerEntityMapper::map);
  }
}
