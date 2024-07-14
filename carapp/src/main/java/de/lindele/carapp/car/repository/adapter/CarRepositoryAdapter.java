package de.lindele.carapp.car.repository.adapter;

import de.lindele.carapp.car.repository.mapper.CarEntityMapper;
import de.lindele.carapp.car.repository.model.CarEntity;
import de.lindele.carapp.car.service.model.Car;
import de.lindele.carapp.car.service.port.CarPersistencePort;
import de.lindele.carapp.exception.ResourceNotFoundException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/** Adapter class to implement the CarPersistencePort interface and interact with the database. */
@Repository
@RequiredArgsConstructor
public class CarRepositoryAdapter implements CarPersistencePort {

  private final CarRepository carRepository;
  private final CarEntityMapper carEntityMapper;

  /**
   * Find a car by its id.
   *
   * @param id the id of the car
   * @return the car
   */
  @Override
  public Car findCarById(Long id) {
    return carRepository.findById(id).map(carEntityMapper::map).orElse(null);
  }

  /**
   * Find all cars.
   *
   * @param pageable the pageable object
   * @return a page of cars
   */
  @Override
  public Page<Car> findAllCars(Pageable pageable) {
    return carRepository.findAll(pageable).map(carEntityMapper::map);
  }

  /**
   * Find all cars by brand.
   *
   * @param brand the brand of the car
   * @param pageable the pageable object
   * @return a page of cars
   */
  public Page<Car> findAllCarsByBrand(String brand, Pageable pageable) {
    return carRepository.findByBrand(brand, pageable).map(carEntityMapper::map);
  }

  /**
   * Find all cars by brand and color.
   *
   * @param brand the brand of the car
   * @param color the color of the car
   * @param pageable the pageable object
   * @return a page of cars
   */
  @Override
  public Page<Car> findAllCarsByBrandAndColor(String brand, String color, Pageable pageable) {
    return carRepository.findAllByBrandAndColor(brand, color, pageable).map(carEntityMapper::map);
  }

  /**
   * Find all cars by color.
   *
   * @param color the color of the car
   * @param pageable the pageable object
   * @return a page of cars
   */
  @Override
  public Page<Car> findAllCarsByColor(String color, Pageable pageable) {
    return carRepository.findAllByColor(color, pageable).map(carEntityMapper::map);
  }

  /**
   * Save a car.
   *
   * @param car the car to save
   * @return the saved car
   */
  @Override
  public Car saveCar(Car car) {
    CarEntity savedCar = carRepository.save(carEntityMapper.map(car));
    return carEntityMapper.map(savedCar);
  }

  /**
   * Update a car.
   *
   * @param car the car to update
   * @return the updated car
   */
  @Override
  public Car updateCar(Car car) {
    Optional<CarEntity> savedCar = carRepository.findById(car.getId());
    if (savedCar.isPresent()) {
      CarEntity savedEntity = savedCar.get();
      // Copy all properties from car to savedEntity except id
      // Using Beanutils because mapper does copy all properties
      BeanUtils.copyProperties(car, savedEntity, "id");
      CarEntity updatedEntity = carRepository.save(savedEntity);
      return carEntityMapper.map(updatedEntity);
    } else {
      throw new ResourceNotFoundException("Car not found with id: " + car.getId());
    }
  }

  /**
   * Delete a car by its id.
   *
   * @param id the id of the car
   */
  @Override
  public void deleteCar(Long id) {
    if (carRepository.existsById(id)) {
      carRepository.deleteById(id);
    } else throw new ResourceNotFoundException("Car not found with id: " + id);
  }
}
