package de.lindele.carapp.customer.service.port;

import de.lindele.carapp.customer.service.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerPersistencePort {

  Customer findCustomerById(Long id);

  Customer saveCustomer(Customer customer);

  Customer updateCustomer(Customer customer);

  void deleteCustomer(Long id);

  Page<Customer> findAllCustomer(Pageable pageable);

  Page<Customer> findAllCustomerByFirstName(String firstName, Pageable pageable);

  Page<Customer> findAllCustomerByLastName(String lastName, Pageable pageable);

  Page<Customer> findAllCustomerByFirstNameAndLastName(
      String firstName, String lastName, Pageable pageable);
}
