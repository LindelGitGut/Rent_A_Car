package de.lindele.carapp.customer.repository.adapter;

import de.lindele.carapp.customer.repository.model.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** Repository for managing customers. */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

  /**
   * Finds a customer by first name.
   *
   * @param firstName The first name of the customer.
   * @param pageable The pageable object.
   * @return The found customer.
   */
  Page<CustomerEntity> findByFirstname(String firstName, Pageable pageable);

  /**
   * Finds a customer by last name.
   *
   * @param lastName The last name of the customer.
   * @param pageable The pageable object.
   * @return The found customer.
   */
  Page<CustomerEntity> findByLastname(String lastName, Pageable pageable);

  /**
   * Finds a customer by first name and last name.
   *
   * @param firstName The first name of the customer.
   * @param lastName The last name of the customer.
   * @param pageable The pageable object.
   * @return The found customer.
   */
  Page<CustomerEntity> findByFirstnameAndLastname(
      String firstName, String lastName, Pageable pageable);
}
