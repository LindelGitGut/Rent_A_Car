package de.lindele.carapp.car.controller.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

import lombok.*;



@Data
@Builder

public class CreateCarRequest {

  @NotNull @NotBlank private String brand;

  @NotNull @NotBlank private String model;

  @NotNull @NotBlank private String color;

  @NotNull @NotBlank private String registrationNumber;

  @NotNull @NotBlank private int kilometer;

  @NotNull @NotBlank private BigDecimal pricePerKilometer;
}
