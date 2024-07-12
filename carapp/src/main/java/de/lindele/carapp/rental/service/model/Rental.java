package de.lindele.carapp.rental.service.model;

import de.lindele.carapp.car.service.model.Car;
import java.util.Date;

import de.lindele.carapp.customer.service.model.Customer;
import lombok.*;

@Data
@Builder
@RequiredArgsConstructor
public class Rental {
  private Long id;
  private Customer customer;
  private Car car;
  private Date rentalDate;
  private Date returnDate;
  private Integer kilometers;
}
