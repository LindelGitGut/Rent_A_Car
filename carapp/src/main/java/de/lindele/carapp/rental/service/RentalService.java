package de.lindele.carapp.rental.service;

import de.lindele.carapp.car.service.model.Car;
import de.lindele.carapp.car.service.port.CarPersistencePort;
import de.lindele.carapp.customer.service.model.Customer;
import de.lindele.carapp.customer.service.port.CustomerPersistencePort;
import de.lindele.carapp.exception.CarAlreadyRentedException;
import de.lindele.carapp.rental.service.model.Rental;
import de.lindele.carapp.rental.service.port.RentalPersistencePort;
import java.sql.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/** Rental Service. */
@Service
@RequiredArgsConstructor
public class RentalService {

  private final RentalPersistencePort rentalPersistencePort;
  private final CarPersistencePort carPersistencePort;
  private final CustomerPersistencePort customerPersistencePort;

  /**
   * Creates a rental.
   *
   * @param startDate the start date
   * @param endDate the end date
   * @param carId the car id
   * @param customerId the customer id
   * @return the created rental
   */
  public Rental createRental(Date startDate, Date endDate, Long carId, Long customerId) {

    if (rentalPersistencePort.existsByCarIdAndDateRange(carId, startDate, endDate)) {
      throw new CarAlreadyRentedException("Car is already rented in this date range");
    }
    // Check if car and customer exist
    Car car = carPersistencePort.findCarById(carId);
    Customer customer = customerPersistencePort.findCustomerById(customerId);

    // create Rental Object
    Rental rental =
        Rental.builder()
            .car(car)
            .customer(customer)
            .rentalDate(startDate)
            .returnDate(endDate)
            .build();

    return rentalPersistencePort.createRental(rental);
  }

  /**
   * Gets a rental by id.
   *
   * @param id the id
   * @return the rental
   */
  public Rental getRental(Long id) {
    return rentalPersistencePort.getRental(id);
  }

  /**
   * Gets all rentals.
   *
   * @param pageable the pageable
   * @return the rentals
   */
  public Page<Rental> getAllRentals(Pageable pageable) {
    return rentalPersistencePort.getAllRentals(pageable);
  }

  /**
   * Gets all rentals by car id.
   *
   * @param carId the car id
   * @param pageable the pageable
   * @return the rentals
   */
  public Page<Rental> getAllRentalsByCarId(Long carId, Pageable pageable) {
    return rentalPersistencePort.getAllRentalsByCarId(carId, pageable);
  }

  /**
   * Gets all rentals by customer id.
   *
   * @param customerId the customer id
   * @param pageable the pageable
   * @return the rentals
   */
  public Page<Rental> getAllRentalsByCustomerId(Long customerId, Pageable pageable) {
    return rentalPersistencePort.getAllRentalsByCustomerId(customerId, pageable);
  }

  /**
   * Gets all rentals by car id and customer id.
   *
   * @param carId the car id
   * @param customerId the customer id
   * @param pageable the pageable
   * @return the rentals
   */
  public Page<Rental> getAllRentalsByCarIdAndCustomerId(
      Long carId, Long customerId, Pageable pageable) {

    return rentalPersistencePort.getAllRentalsByCarIdAndCustomerId(carId, customerId, pageable);
  }

  /**
   * Updates a rental.
   *
   * @param rentalId the rental id
   * @param kilometersDriven the kilometers driven
   * @param startDate the start date
   * @param endDate the end date
   * @param carId the car id
   * @param customerId the customer id
   * @return the updated rental
   */
  public Rental updateRental(
      Long rentalId,
      Integer kilometersDriven,
      Date startDate,
      Date endDate,
      Long carId,
      Long customerId) {

    // Check if car and customer exist
    Car car = carPersistencePort.findCarById(carId);
    Customer customer = customerPersistencePort.findCustomerById(customerId);

    // create Rental Object
    Rental rental =
        Rental.builder()
            .id(rentalId)
            .car(car)
            .customer(customer)
            .rentalDate(startDate)
            .returnDate(endDate)
            .kilometerDriven(kilometersDriven)
            .build();

    return rentalPersistencePort.updateRental(rental, rentalId);
  }

  /**
   * Deletes a rental.
   *
   * @param id the id
   */
  public void deleteRental(Long id) {
    rentalPersistencePort.deleteRental(id);
  }
}
