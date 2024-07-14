package de.lindele.carapp.customer.service.port;

import de.lindele.carapp.customer.service.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/** Port for the customer persistence. */
public interface CustomerPersistencePort {

  /**
   * Finds a customer by id.
   *
   * @param id The id of the customer.
   * @return The found customer.
   */
  Customer findCustomerById(Long id);

  /**
   * Saves a customer.
   *
   * @param customer The customer to save.
   * @return The saved customer.
   */
  Customer saveCustomer(Customer customer);

  /**
   * Updates a customer.
   *
   * @param customer The customer to update.
   * @return The updated customer.
   */
  Customer updateCustomer(Customer customer);

  /**
   * Deletes a customer.
   *
   * @param id The id of the customer to delete.
   */
  void deleteCustomer(Long id);

  /**
   * Finds all customers.
   *
   * @param pageable The pageable object.
   * @return The found customers.
   */
  Page<Customer> findAllCustomer(Pageable pageable);

  /**
   * Finds a customer by first name.
   *
   * @param firstName The first name of the customer.
   * @param pageable The pageable object.
   * @return The found customer.
   */
  Page<Customer> findAllCustomerByFirstName(String firstName, Pageable pageable);

  /**
   * Finds a customer by last name.
   *
   * @param lastName The last name of the customer.
   * @param pageable The pageable object.
   * @return The found customer.
   */
  Page<Customer> findAllCustomerByLastName(String lastName, Pageable pageable);

  /**
   * Finds a customer by first name and last name.
   *
   * @param firstName The first name of the customer.
   * @param lastName The last name of the customer.
   * @param pageable The pageable object.
   * @return The found customer.
   */
  Page<Customer> findAllCustomerByFirstNameAndLastName(
      String firstName, String lastName, Pageable pageable);
}
