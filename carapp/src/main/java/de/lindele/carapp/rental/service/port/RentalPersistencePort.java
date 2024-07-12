package de.lindele.carapp.rental.service.port;

import de.lindele.carapp.rental.service.model.Rental;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RentalPersistencePort {

  // CREATE

  Rental createRental(Rental rental);

  // READ

  Rental getRental(Long id);

  Page<Rental> getAllRentals(Pageable pageable);

  // UPDATE

  Page<Rental> getAllRentalsByCarId(Long carId, Pageable pageable);

  Page<Rental> getAllRentalsByCustomerId(Long customerId, Pageable pageable);


  Rental updateRental(Rental rental, Long id);

  // DELETE
  void deleteRental(Long id);
}
