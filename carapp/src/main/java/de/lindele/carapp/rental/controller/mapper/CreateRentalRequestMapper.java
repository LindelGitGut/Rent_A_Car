package de.lindele.carapp.rental.controller.mapper;

import de.lindele.carapp.rental.controller.model.request.CreateRentalRequest;
import de.lindele.carapp.rental.service.model.Rental;
import org.springframework.stereotype.Component;

// TODO Request mit carid und customer id? was ist besser, eigentlich id von car und customer aber
// wo customer und car id abfragen aus der db?
@Component
public class CreateRentalRequestMapper {

  Rental map(CreateRentalRequest createRentalRequest) {
    return Rental.builder()
        //                .car(createRentalRequest.getCarId())
        //                .customerId(createRentalRequest.getCustomerId())
        //                .startDate(createRentalRequest.getStartDate())
        //                .endDate(createRentalRequest.getEndDate())
        .build();
  }
}
