package de.lindele.carapp.car.service;

import de.lindele.carapp.car.service.model.Car;
import de.lindele.carapp.car.service.port.CarPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/** Service class for handling car related operations. */
@Service
@RequiredArgsConstructor
public class CarService {

  private final CarPersistencePort carPersistencePort;

  /**
   * Returns a car by id.
   *
   * @param id the id of the car
   * @return the car
   */
  public Car getCarById(Long id) {
    return carPersistencePort.findCarById(id);
  }

  /**
   * Returns all cars.
   *
   * @param pageable the pageable object
   * @return the page of cars
   */
  public Page<Car> getAllCars(Pageable pageable) {
    return carPersistencePort.findAllCars(pageable);
  }

  /**
   * Creates a new car.
   *
   * @param car the car to create
   * @return the created car
   */
  public Car createCar(Car car) {
    return carPersistencePort.saveCar(car);
  }

  /**
   * Returns all cars by brand.
   *
   * @param brand the brand to filter by
   * @param pageable the pageable object
   * @return the page of cars
   */
  public Page<Car> getAllCarsByBrand(String brand, Pageable pageable) {
    return carPersistencePort.findAllCarsByBrand(brand, pageable);
  }

  /**
   * Returns all cars by color.
   *
   * @param color the color to filter by
   * @param pageable the pageable object
   * @return the page of cars
   */
  public Page<Car> getAllCarsByColor(String color, Pageable pageable) {
    return carPersistencePort.findAllCarsByColor(color, pageable);
  }

  /**
   * Returns all cars by brand and color.
   *
   * @param brand the brand to filter by
   * @param color the color to filter by
   * @param pageable the pageable object
   * @return the page of cars
   */
  public Page<Car> getAllCarsByBrandAndColor(String brand, String color, Pageable pageable) {
    return carPersistencePort.findAllCarsByBrandAndColor(brand, color, pageable);
  }

  /**
   * Updates a car.
   *
   * @param car the car to update
   * @return the updated car
   */
  public Car updateCar(Car car) {

    return carPersistencePort.updateCar(car);
  }

  /**
   * Deletes a car.
   *
   * @param id the id of the car to delete
   */
  public void deleteCar(Long id) {
    carPersistencePort.deleteCar(id);
  }
}
