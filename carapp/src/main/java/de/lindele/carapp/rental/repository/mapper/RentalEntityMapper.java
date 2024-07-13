package de.lindele.carapp.rental.repository.mapper;

import de.lindele.carapp.car.repository.mapper.CarEntityMapper;
import de.lindele.carapp.car.repository.model.CarEntity;
import de.lindele.carapp.customer.repository.mapper.CustomerEntityMapper;
import de.lindele.carapp.rental.repository.model.RentalEntity;
import de.lindele.carapp.rental.service.model.Rental;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// TODO fix Customer Mapping

@Component
@RequiredArgsConstructor
public class RentalEntityMapper {

  private final CarEntityMapper carEntityMapper;

  private final CustomerEntityMapper customerEntityMapper;

  public Rental map(RentalEntity rentalEntity) {

    return Rental.builder()
        .id(rentalEntity.getId())
        .car(carEntityMapper.map(rentalEntity.getCar()))
        .rentalDate(rentalEntity.getRentalStart())
        .returnDate(rentalEntity.getRentalEnd())
            // new rental entity has no kilometers driven therefore set null to 0
        .kilometers(rentalEntity.getKilometersDriven() == null ? 0 : rentalEntity.getKilometersDriven())
        .customer(customerEntityMapper.map(rentalEntity.getCustomer()))
        .build();
  }

  public RentalEntity map(Rental rental) {
    return RentalEntity.builder()
        .id(rental.getId())
        .car(CarEntity.builder().id(rental.getCar().getId()).build())
        .rentalStart(rental.getRentalDate())
        .rentalEnd(rental.getReturnDate())
        .kilometersDriven(rental.getKilometers())
        .build();
  }
}
