package de.lindele.carapp.car.controller.model;

// TODO define model

import java.math.BigDecimal;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarWebModel {

  // TODO check which Properties are needed for Webmodel

  private String brand;
  private String model;
  private String registrationNumber;
  private String color;
  private Integer drivenKilometers;
  private BigDecimal pricePerKilometer;
}
