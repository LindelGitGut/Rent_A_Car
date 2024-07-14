package de.lindele.carapp.rental.repository.mapper;

import de.lindele.carapp.car.repository.mapper.CarEntityMapper;
import de.lindele.carapp.customer.repository.mapper.CustomerEntityMapper;
import de.lindele.carapp.rental.repository.model.RentalEntity;
import de.lindele.carapp.rental.service.model.Rental;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/** Maps a rental entity to a rental and vice versa. */
@Component
@RequiredArgsConstructor
public class RentalEntityMapper {

  private final CarEntityMapper carEntityMapper;

  private final CustomerEntityMapper customerEntityMapper;

  /**
   * Maps a rental entity to a rental.
   *
   * @param rentalEntity the rental entity
   * @return the rental
   */
  public Rental map(RentalEntity rentalEntity) {

    Rental rental =
        Rental.builder()
            .id(rentalEntity.getId())
            .car(carEntityMapper.map(rentalEntity.getCar()))
            .rentalDate(rentalEntity.getRentalStart())
            .returnDate(rentalEntity.getRentalEnd())
            // new rental entity has no kilometers driven therefore set null to 0
            .kilometerDriven(rentalEntity.getKilometersDriven())
            .customer(customerEntityMapper.map(rentalEntity.getCustomer()))
            .build();

    return rental;
  }

  /**
   * Maps a rental to a rental entity.
   *
   * @param rental the rental
   * @return the rental entity
   */
  public RentalEntity map(Rental rental) {

    RentalEntity rentalEntity =
        RentalEntity.builder()
            .id(rental.getId())
            .car(carEntityMapper.map(rental.getCar()))
            .customer(customerEntityMapper.map(rental.getCustomer()))
            .rentalStart(rental.getRentalDate())
            .rentalEnd(rental.getReturnDate())
            .kilometersDriven(rental.getKilometerDriven() == null ? 0 : rental.getKilometerDriven())
            .build();

    return rentalEntity;
  }
}
