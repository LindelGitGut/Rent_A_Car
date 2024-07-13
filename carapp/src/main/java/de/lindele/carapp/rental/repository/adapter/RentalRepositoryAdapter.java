package de.lindele.carapp.rental.repository.adapter;

import de.lindele.carapp.exception.ResourceNotFoundException;
import de.lindele.carapp.rental.repository.mapper.RentalEntityMapper;
import de.lindele.carapp.rental.repository.model.RentalEntity;
import de.lindele.carapp.rental.service.model.Rental;
import de.lindele.carapp.rental.service.port.RentalPersistencePort;
import java.sql.Date;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RentalRepositoryAdapter implements RentalPersistencePort {

  private final RentalRepository rentalRepository;

  private final RentalEntityMapper rentalEntityMapper;

  @Override
  public Rental createRental(Rental rental) {
    RentalEntity rentalEntity = rentalEntityMapper.map(rental);
    return rentalEntityMapper.map(rentalRepository.save(rentalEntityMapper.map(rental)));
  }

  @Override
  public Rental getRental(Long id) {
    Optional<RentalEntity> rentalEntity = rentalRepository.findById(id);
    if (rentalEntity.isPresent()) {
      return rentalEntityMapper.map(rentalEntity.get());
    } else {
      throw new ResourceNotFoundException("Rental with id " + id + " not found");
    }
  }

  @Override
  public boolean existsByCarIdAndDateRange(Long carId, Date startDate, Date endDate) {
    return rentalRepository.existsByCarIdAndDateRange(carId, startDate, endDate);
  }

  @Override
  public Page<Rental> getAllRentals(Pageable pageable) {
    return rentalRepository.findAll(pageable).map(rentalEntityMapper::map);
  }

  @Override
  public Page<Rental> getAllRentalsByCarId(Long carId, Pageable pageable) {
    return rentalRepository.findAllByCarId(carId, pageable).map(rentalEntityMapper::map);
  }

  @Override
  public Page<Rental> getAllRentalsByCustomerId(Long customerId, Pageable pageable) {
    return rentalRepository.findAllByCustomerId(customerId, pageable).map(rentalEntityMapper::map);
  }

  @Override
  public Rental updateRental(Rental rental, Long id) {
    Optional<RentalEntity> savedRentalEntity = rentalRepository.findById(id);
    if (savedRentalEntity.isPresent()) {
      RentalEntity rentalEntity = rentalEntityMapper.map(rental);
      rentalEntity.setId(id);
      return rentalEntityMapper.map(rentalRepository.save(rentalEntity));
    } else {
      throw new ResourceNotFoundException("Rental with id " + id + " not found");
    }
  }

  @Override
  public void deleteRental(Long id) {
    Optional<RentalEntity> rentalEntity = rentalRepository.findById(id);
    if (rentalEntity.isPresent()) {
      rentalRepository.deleteById(id);
    } else {
      throw new ResourceNotFoundException("Rental with id " + id + " not found");
    }
  }
}
