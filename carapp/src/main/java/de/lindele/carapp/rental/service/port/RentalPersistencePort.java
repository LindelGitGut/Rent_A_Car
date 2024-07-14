package de.lindele.carapp.rental.service.port;

import de.lindele.carapp.rental.service.model.Rental;
import java.sql.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/** Rental Persistence Port. */
public interface RentalPersistencePort {

  // CREATE

  /**
   * Creates a rental.
   *
   * @param rental the rental
   * @return the created rental
   */
  Rental createRental(Rental rental);

  // READ

  /**
   * Gets a rental by id.
   *
   * @param id the id
   * @return the rental
   */
  Rental getRental(Long id);

  /**
   * Checks if a rental exists by car id and date range.
   *
   * @param carId the car id
   * @param startDate the start date
   * @param endDate the end date
   * @return true if the rental exists, false otherwise
   */
  boolean existsByCarIdAndDateRange(Long carId, Date startDate, Date endDate);

  /**
   * Gets all rentals.
   *
   * @param pageable the pageable
   * @return the rentals
   */
  Page<Rental> getAllRentals(Pageable pageable);

  /**
   * Gets all rentals by car id.
   *
   * @param carId the car id
   * @param pageable the pageable
   * @return the rentals
   */
  Page<Rental> getAllRentalsByCarId(Long carId, Pageable pageable);

  /**
   * Gets all rentals by customer id.
   *
   * @param customerId the customer id
   * @param pageable the pageable
   * @return the rentals
   */
  Page<Rental> getAllRentalsByCustomerId(Long customerId, Pageable pageable);

  /**
   * Gets all rentals by car id and customer id.
   *
   * @param carId the car id
   * @param customerId the customer id
   * @param pageable the pageable
   * @return the rentals
   */
  Page<Rental> getAllRentalsByCarIdAndCustomerId(Long carId, Long customerId, Pageable pageable);

  // UPDATE

  /**
   * Updates a rental.
   *
   * @param rental the rental
   * @param id the id
   * @return the updated rental
   */
  Rental updateRental(Rental rental, Long id);

  // DELETE

  /**
   * Deletes a rental by id.
   *
   * @param id the id
   */
  void deleteRental(Long id);
}
