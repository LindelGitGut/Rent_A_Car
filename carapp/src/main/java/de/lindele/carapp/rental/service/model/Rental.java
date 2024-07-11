package de.lindele.carapp.rental.service.model;

import de.lindele.carapp.car.service.model.Car;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rental {

  private Long id;
  private Long customerId;
  private Car car;
  private Date rentalDate;
  private Date returnDate;
  private Integer kilometers;
}
