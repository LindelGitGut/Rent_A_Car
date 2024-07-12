package de.lindele.carapp.rental.service;

import de.lindele.carapp.rental.service.model.Rental;
import de.lindele.carapp.rental.service.port.RentalPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentalService {

  private final RentalPersistencePort rentalPersistencePort;

  public Rental createRental(Rental rental) {
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
