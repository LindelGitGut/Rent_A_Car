package de.lindele.carapp.car.repository.mapper;

import de.lindele.carapp.car.repository.model.CarEntity;
import de.lindele.carapp.car.service.model.Car;
import org.springframework.stereotype.Component;

/** Mapper class to map between Car and CarEntity */
@Component
public class CarEntityMapper {

  /**
   * Maps a CarEntity to a Car
   *
   * @param carEntity the CarEntity to map
   * @return the mapped Car
   */
  public Car map(CarEntity carEntity) {
    Car car = new Car();
    car.setId(carEntity.getId());
    car.setBrand(carEntity.getBrand());
    car.setModel(carEntity.getModel());
    car.setRegistrationNumber(carEntity.getRegistrationNumber());
    car.setDrivenkilometers(carEntity.getKilometer());
    car.setPricePerKilometer(carEntity.getPricePerKilometer());
    car.setColor(carEntity.getColor());
    return car;
  }

  /**
   * Maps a Car to a CarEntity
   *
   * @param car the Car to map
   * @return the mapped CarEntity
   */
  public CarEntity map(Car car) {
    CarEntity carEntity = new CarEntity();
    carEntity.setId(car.getId());
    carEntity.setBrand(car.getBrand());
    carEntity.setModel(car.getModel());
    carEntity.setRegistrationNumber(car.getRegistrationNumber());
    carEntity.setKilometer(car.getDrivenkilometers());
    carEntity.setPricePerKilometer(car.getPricePerKilometer());
    carEntity.setColor(car.getColor());
    return carEntity;
  }
}
