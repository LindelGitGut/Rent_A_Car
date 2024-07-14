package de.lindele.carapp.car.controller.mapper;

import de.lindele.carapp.car.controller.model.CarWebModel;
import de.lindele.carapp.car.service.model.Car;
import org.springframework.stereotype.Component;

/** Maps CarWebModel to Car and vice versa. */
@Component
public class CarWebModelMapper {

  /**
   * Maps CarWebModel to Car.
   *
   * @param carWebModel CarWebModel
   * @return Car
   */
  public Car map(CarWebModel carWebModel) {

    Car car = new Car();
    car.setModel(carWebModel.getModel());
    car.setBrand(carWebModel.getBrand());
    car.setDrivenkilometers(carWebModel.getDrivenKilometers());
    car.setRegistrationNumber(carWebModel.getRegistrationNumber());
    car.setPricePerKilometer(carWebModel.getPricePerKilometer());
    car.setColor(carWebModel.getColor());
    return car;
  }

  /**
   * Maps Car to CarWebModel.
   *
   * @param car Car
   * @return CarWebModel
   */
  public CarWebModel map(Car car) {
    CarWebModel carWebModel = new CarWebModel();
    carWebModel.setModel(car.getModel());
    carWebModel.setBrand(car.getBrand());
    carWebModel.setDrivenKilometers(car.getDrivenkilometers());
    carWebModel.setRegistrationNumber(car.getRegistrationNumber());
    carWebModel.setPricePerKilometer(car.getPricePerKilometer());
    carWebModel.setColor(car.getColor());
    return carWebModel;
  }
}
