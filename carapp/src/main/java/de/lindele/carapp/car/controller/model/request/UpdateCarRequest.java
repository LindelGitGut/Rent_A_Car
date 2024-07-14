package de.lindele.carapp.car.controller.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.*;

/** Request object to update a car. */
@Data
@AllArgsConstructor
@Builder
public class UpdateCarRequest {

  @NotBlank @NotBlank private String brand;
  @NotNull @NotBlank private String model;
  @NotNull @NotBlank private String color;
  @NotNull @NotBlank private String registrationNumber;
  @NotNull private int kilometer; // Kilometerstand
  @NotNull private BigDecimal pricePerKilometer;
}
