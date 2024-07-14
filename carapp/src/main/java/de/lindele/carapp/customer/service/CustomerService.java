package de.lindele.carapp.customer.service;

import de.lindele.carapp.customer.service.model.Customer;
import de.lindele.carapp.customer.service.port.CustomerPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/** Service for managing customers. */
@Service
@RequiredArgsConstructor
public class CustomerService {

  private final CustomerPersistencePort customerPersistencePort;

  /**
   * Creates a customer.
   *
   * @param customer The customer to create.
   * @return The created customer.
   */
  public Customer createCustomer(Customer customer) {
    return customerPersistencePort.saveCustomer(customer);
  }

  /**
   * Updates a customer.
   *
   * @param customer The customer to update.
   * @param id The id of the customer to update.
   * @return The updated customer.
   */
  public Customer updateCustomer(Customer customer, Long id) {
    customer.setId(id);
    return customerPersistencePort.updateCustomer(customer);
  }

  /**
   * Deletes a customer.
   *
   * @param id The id of the customer to delete.
   */
  public void deleteCustomer(Long id) {
    customerPersistencePort.deleteCustomer(id);
  }

  /**
   * Finds a customer by id.
   *
   * @param id The id of the customer.
   * @return The found customer.
   */
  public Customer getCustomerById(Long id) {
    return customerPersistencePort.findCustomerById(id);
  }

  /**
   * Gets all customers.
   *
   * @param pageable The pageable object.
   * @return The found customers.
   */
  public Page<Customer> getAllCustomers(Pageable pageable) {
    return customerPersistencePort.findAllCustomer(pageable);
  }

  /**
   * Gets all customers by first name.
   *
   * @param firstname The first name of the customer.
   * @param pageable The pageable object.
   * @return The found customers.
   */
  public Page<Customer> getAllCustomersByFirstName(String firstname, Pageable pageable) {
    return customerPersistencePort.findAllCustomerByFirstName(firstname, pageable);
  }

  /**
   * Gets all customers by last name.
   *
   * @param lastname The last name of the customer.
   * @param pageable The pageable object.
   * @return The found customers.
   */
  public Page<Customer> getAllCustomersByLastName(String lastname, Pageable pageable) {
    return customerPersistencePort.findAllCustomerByLastName(lastname, pageable);
  }

  /**
   * Gets all customers by first name and last name.
   *
   * @param firstname The first name of the customer.
   * @param lastname The last name of the customer.
   * @param pageable The pageable object.
   * @return The found customers.
   */
  public Page<Customer> getAllCustomersByFirstNameAndLastName(
      String firstname, String lastname, Pageable pageable) {
    return customerPersistencePort.findAllCustomerByFirstNameAndLastName(
        firstname, lastname, pageable);
  }
}
