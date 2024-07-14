package de.lindele.carapp.car.controller.mapper;

import de.lindele.carapp.car.controller.model.request.CreateCarRequest;
import de.lindele.carapp.car.service.model.Car;
import org.springframework.stereotype.Component;

/** Maps CreateCarRequest to Car and vice versa. */
@Component
public class CreateCarRequestMapper {

  /**
   * Maps CreateCarRequest to Car.
   *
   * @param createCarRequest CreateCarRequest
   * @return Car
   */
  public Car map(CreateCarRequest createCarRequest) {
    Car car = new Car();
    car.setBrand(createCarRequest.getBrand());
    car.setModel(createCarRequest.getModel());
    car.setColor(createCarRequest.getColor());
    car.setRegistrationNumber(createCarRequest.getRegistrationNumber());
    car.setDrivenkilometers(createCarRequest.getKilometer());
    car.setPricePerKilometer(createCarRequest.getPricePerKilometer());

    return car;
  }

  /**
   * Maps Car to CreateCarRequest.
   *
   * @param car Car
   * @return CreateCarRequest
   */
  public CreateCarRequest map(Car car) {
    CreateCarRequest createCarRequest =
        CreateCarRequest.builder()
            .brand(car.getBrand())
            .model(car.getModel())
            .color(car.getColor())
            .registrationNumber(car.getRegistrationNumber())
            .kilometer(car.getDrivenkilometers())
            .pricePerKilometer(car.getPricePerKilometer())
            .build();
    return createCarRequest;
  }
}
