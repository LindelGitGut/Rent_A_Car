package de.lindele.carapp.rental.service.model;

import de.lindele.carapp.car.service.model.Car;
import de.lindele.carapp.customer.service.model.Customer;
import java.util.Date;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class Rental {
  private Long id;
  private Customer customer;
  private Car car;
  private Date rentalDate;
  private Date returnDate;
  private Integer kilometers;
}
