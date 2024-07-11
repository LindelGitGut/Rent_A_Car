package de.lindele.carapp.rental.controller.model;

import de.lindele.carapp.car.service.model.Car;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class RentalWebModel {

  @NotNull private Long rentalNumber;

  //    @NotNull
  //    @NotBlank
  //    private String customerName;

  @NotNull private Car car;

  @NotNull private Date rentalDate;

  @NotNull private Date returnDate;

  @NotNull private int rentalKilometers;
}
