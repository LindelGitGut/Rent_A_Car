package de.lindele.carapp.rental.controller.model;

import de.lindele.carapp.car.controller.model.CarWebModel;
import de.lindele.carapp.customer.controller.model.CustomerWebModel;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import lombok.*;

@Data
@Builder
public class RentalWebModel {

  @NotNull private Long rentalNumber;

  @NotNull private CustomerWebModel customer;

  @NotNull private CarWebModel car;

  @NotNull private Date startDate;

  private Date returnDate;

  @NotNull private int kilometersDriven;
}
