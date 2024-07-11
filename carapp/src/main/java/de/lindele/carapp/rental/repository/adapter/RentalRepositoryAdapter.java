package de.lindele.carapp.rental.repository.adapter;

import de.lindele.carapp.rental.repository.mapper.RentalEntityMapper;
import de.lindele.carapp.rental.service.model.Rental;
import de.lindele.carapp.rental.service.port.RentalPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RentalRepositoryAdapter implements RentalPersistencePort {

  private RentalRepository rentalRepository;

  private RentalEntityMapper rentalEntityMapper;

  @Override
  public Rental createRental(Rental rental) {
    //        RentalEntity rentalEntity = rentalEntityMapper.map(rental);
    //        rentalRepository.save();
    return null;
  }

  @Override
  public Rental getRental(Long id) {
    return null;
  }

  @Override
  public Page<Rental> getAllRentals(Pageable pageable) {
    return null;
  }

  @Override
  public Rental updateRental(Rental rental, Long id) {
    return null;
  }

  @Override
  public void deleteRental(Long id) {}
}
