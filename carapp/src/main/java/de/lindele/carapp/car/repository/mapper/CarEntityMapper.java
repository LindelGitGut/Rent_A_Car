package de.lindele.carapp.car.repository.mapper;

import de.lindele.carapp.car.repository.model.CarEntity;
import de.lindele.carapp.car.service.model.Car;
import org.springframework.stereotype.Component;

@Component
public class CarEntityMapper {

  public Car map(CarEntity carEntity) {
    Car car = new Car();
    car.setBrand(carEntity.getBrand());
    car.setModel(carEntity.getModel());
    car.setRegistrationNumber(carEntity.getRegistrationNumber());
    car.setDrivenkilometers(carEntity.getKilometer());
    car.setPricePerKilometer(carEntity.getPricePerKilometer());
    car.setColor(carEntity.getColor());
    return car;
  }

  public CarEntity map(Car car) {
    CarEntity carEntity = new CarEntity();
    carEntity.setBrand(car.getBrand());
    carEntity.setModel(car.getModel());
    carEntity.setRegistrationNumber(car.getRegistrationNumber());
    carEntity.setKilometer(car.getDrivenkilometers());
    carEntity.setPricePerKilometer(car.getPricePerKilometer());
    carEntity.setColor(car.getColor());
    return carEntity;
  }
}
