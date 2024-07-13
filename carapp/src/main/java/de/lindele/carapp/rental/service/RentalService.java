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

@Service
@RequiredArgsConstructor
public class RentalService {

  private final RentalPersistencePort rentalPersistencePort;
  private final CarPersistencePort carPersistencePort;
  private final CustomerPersistencePort customerPersistencePort;

  public Rental createRental(Date startDate, Date endDate, Long carId, Long customerId) {

    if (rentalPersistencePort.existsByCarIdAndDateRange(carId, startDate, endDate)) {
      throw new CarAlreadyRentedException("Car is already rented in this date range");
    }

    Car car = carPersistencePort.findCarById(carId);
    Customer customer = customerPersistencePort.findCustomerById(customerId);

    Rental rental =
        Rental.builder()
            .car(car)
            .customer(customer)
            .rentalDate(startDate)
            .returnDate(endDate)
            .build();
    return rentalPersistencePort.createRental(rental);
  }

  public Rental getRental(Long id) {
    return rentalPersistencePort.getRental(id);
  }

  public Page<Rental> getAllRentals(Pageable pageable) {
    return rentalPersistencePort.getAllRentals(pageable);
  }

  public Page<Rental> getAllRentalsByCarId(Long carId, Pageable pageable) {
    return rentalPersistencePort.getAllRentalsByCarId(carId, pageable);
  }

  public Page<Rental> getAllRentalsByCustomerId(Long customerId, Pageable pageable) {
    return rentalPersistencePort.getAllRentalsByCustomerId(customerId, pageable);
  }

  public Rental updateRental(Rental rental, Long id) {
    return rentalPersistencePort.updateRental(rental, id);
  }

  public void deleteRental(Long id) {
    rentalPersistencePort.deleteRental(id);
  }
}
