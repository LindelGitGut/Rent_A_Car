package de.lindele.carapp.rental.controller.mapper;

import de.lindele.carapp.car.controller.mapper.CarWebModelMapper;
import de.lindele.carapp.customer.controller.mapper.CustomerWebModelMapper;
import de.lindele.carapp.rental.controller.model.RentalWebModel;
import de.lindele.carapp.rental.service.model.Rental;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RentalWebModelMapper {

  private final CarWebModelMapper carWebModelMapper;
  private final CustomerWebModelMapper customerWebModelMapper;

  public RentalWebModel map(Rental rental) {

    return RentalWebModel.builder()
        .rentalNumber(rental.getId())
        .car(carWebModelMapper.map(rental.getCar()))
        .customer(customerWebModelMapper.map(rental.getCustomer()))
        .startDate(rental.getRentalDate())
        .returnDate(rental.getReturnDate())
        .kilometersDriven(rental.getKilometerDriven())
        .build();
  }
}
