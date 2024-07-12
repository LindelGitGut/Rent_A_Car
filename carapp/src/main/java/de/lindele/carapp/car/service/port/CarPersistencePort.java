package de.lindele.carapp.car.service.port;

import de.lindele.carapp.car.service.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/** Port for car persistence operations. */
public interface CarPersistencePort {

  /**
   * find all cars by brand.
   *
   * @param brand The brand of the car.
   * @return List of cars.
   */
  Page<Car> findAllCarsByBrand(String brand, Pageable pageable);

  /**
   * Find all cars.
   *
   * @param pageable The paged car information.
   * @return List of cars.
   */
  Page<Car> findAllCars(Pageable pageable);

  /**
   * Find a car by id.
   *
   * @param id The id of the car.
   * @return The car.
   */
  Car findCarById(Long id);

  /**
   * Find all cars by color.
   *
   * @param color The color of the car.
   * @return List of cars.
   */
  Page<Car> findAllCarsByColor(String color, Pageable pageable);

  /**
   * Find all cars by brand and color.
   *
   * @param brand The brand of the car.
   * @param color The color of the car.
   * @return List of cars.
   */
  Page<Car> findAllCarsByBrandAndColor(String brand, String color, Pageable pageable);

  /**
   * Save a car.
   *
   * @param car The car to save.
   * @return The saved car.
   */
  Car saveCar(Car car);

  /**
   * Update a car.
   *
   * @param car The car to update.
   * @return The updated car.
   */
  Car updateCar(Car car);

  /**
   * Delete a car.
   *
   * @param id The id of the car to delete.
   */
  void deleteCar(Long id);
}
