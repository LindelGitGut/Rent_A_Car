package de.lindele.carapp.car.service;

import de.lindele.carapp.car.service.model.Car;
import de.lindele.carapp.car.service.port.CarPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService {

  private final CarPersistencePort carPersistencePort;

  public Car createCar(Car car) {
    return carPersistencePort.saveCar(car);
  }

  public Page<Car> getAllCarsByBrand(String brand, Pageable pageable) {
    return carPersistencePort.findCarByBrand(brand, pageable);
  }

  public Page<Car> getAllCarsByColor(String color, Pageable pageable) {
    return carPersistencePort.findAllCarsByColor(color, pageable);
  }

  public Page<Car> getAllCarsByBrandAndColor(String brand, String color, Pageable pageable) {
    return carPersistencePort.findAllCarsByBrandAndColor(brand, color, pageable);
  }

  public Page<Car> getAllCars(Pageable pageable) {
    return carPersistencePort.findAllCars(pageable);
  }

  public Car updateCar(Car car, Long id) {

    return carPersistencePort.updateCar(car, id);
  }

  public void deleteCar(Long id) {
    carPersistencePort.deleteCar(id);
  }

  public Car getCarById(Long id) {
    return carPersistencePort.findCarById(id);
  }
}
