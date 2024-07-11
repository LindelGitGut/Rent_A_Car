package de.lindele.carapp.car.controller.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateCarRequest {
  private Long id;
  private String brand;
  private String model;
  private String color;
  private String registrationNumber;
  private int kilometer; // Kilometerstand
  private double pricePerKilometer;
}
