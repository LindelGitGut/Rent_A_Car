package de.lindele.carapp.car.service.model;

import java.math.BigDecimal;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Car {
  private Long id;
  private String brand;
  private String model;
  private String color;
  private String registrationNumber;
  private Integer drivenkilometers;
  private BigDecimal pricePerKilometer;
}
