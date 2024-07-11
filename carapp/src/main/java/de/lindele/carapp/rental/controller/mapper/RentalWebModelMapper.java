package de.lindele.carapp.rental.controller.mapper;

import de.lindele.carapp.rental.controller.model.RentalWebModel;
import de.lindele.carapp.rental.service.model.Rental;
import org.springframework.stereotype.Component;

@Component
public class RentalWebModelMapper {

  RentalWebModel map(Rental rental) {
    RentalWebModel rentalWebModel = new RentalWebModel();
    rentalWebModel.setRentalNumber(rental.getId());
    rentalWebModel.setCar(rental.getCar());
    rentalWebModel.setRentalDate(rental.getRentalDate());
    rentalWebModel.setReturnDate(rental.getReturnDate());
    rentalWebModel.setRentalKilometers(rental.getKilometers());
    return rentalWebModel;
  }
}
