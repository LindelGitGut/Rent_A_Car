package de.lindele.carapp.car.controller.mapper;

import de.lindele.carapp.car.controller.model.request.UpdateCarRequest;
import de.lindele.carapp.car.service.model.Car;
import org.springframework.stereotype.Component;

/** Maps UpdateCarRequest to Car. */
@Component
public class UpdateCarRequestMapper {

  /**
   * Maps UpdateCarRequest to Car.
   *
   * @param updateCarRequest UpdateCarRequest
   * @return Car
   */
  public Car map(UpdateCarRequest updateCarRequest) {
    return Car.builder()
        .brand(updateCarRequest.getBrand())
        .model(updateCarRequest.getModel())
        .color(updateCarRequest.getColor())
        .registrationNumber(updateCarRequest.getRegistrationNumber())
        .drivenkilometers(updateCarRequest.getKilometer())
        .pricePerKilometer(updateCarRequest.getPricePerKilometer())
        .build();
  }
}
