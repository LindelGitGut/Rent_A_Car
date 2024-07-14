package de.lindele.carapp.rental.repository.adapter;

import de.lindele.carapp.car.repository.model.CarEntity;
import de.lindele.carapp.customer.repository.model.CustomerEntity;
import de.lindele.carapp.exception.ResourceNotFoundException;
import de.lindele.carapp.rental.repository.mapper.RentalEntityMapper;
import de.lindele.carapp.rental.repository.model.RentalEntity;
import de.lindele.carapp.rental.service.model.Rental;
import de.lindele.carapp.rental.service.port.RentalPersistencePort;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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

  @PersistenceContext private EntityManager entityManager;

  @Override
  public Rental createRental(Rental rental) {

    // Creating Proxy Object to minimize DB Calls (if Customer or Car is already existing is called
    // in Service Layer)
    CarEntity carProxy = entityManager.getReference(CarEntity.class, rental.getCar().getId());
    CustomerEntity customerProxy =
        entityManager.getReference(CustomerEntity.class, rental.getCustomer().getId());

    RentalEntity rentalEntity = rentalEntityMapper.map(rental);
    rentalEntity.setCar(carProxy);
    rentalEntity.setCustomer(customerProxy);

    RentalEntity savedRental = rentalRepository.save(rentalEntity);
    return rentalEntityMapper.map(savedRental);
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
  public Page<Rental> getAllRentalsByCarIdAndCustomerId(
      Long carId, Long customerId, Pageable pageable) {
    return rentalRepository
        .findAllByCarIdAndCustomerId(carId, customerId, pageable)
        .map(rentalEntityMapper::map);
  }

  @Override
  public Rental updateRental(Rental rental, Long id) {
    Optional<RentalEntity> optRentalEntity = rentalRepository.findById(id);
    if (optRentalEntity.isPresent()) {

      // Creating Proxy Object to minimize DB Calls (if Customer or Car is already existing is
      // called in Service Layer)
      CarEntity carProxy = entityManager.getReference(CarEntity.class, rental.getCar().getId());
      CustomerEntity customerProxy =
          entityManager.getReference(CustomerEntity.class, rental.getCustomer().getId());

      RentalEntity rentalEntity = rentalEntityMapper.map(rental);

      // Get the saved RentalEntity
      RentalEntity savedRentalEntity = optRentalEntity.get();

      savedRentalEntity = rentalEntity;

      // Update the saved RentalEntity
      savedRentalEntity.setCar(carProxy);
      savedRentalEntity.setCustomer(customerProxy);
      savedRentalEntity.setRentalStart(rental.getRentalDate());
      savedRentalEntity.setRentalEnd(rental.getReturnDate());
      savedRentalEntity.setKilometersDriven(rental.getKilometerDriven());

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
