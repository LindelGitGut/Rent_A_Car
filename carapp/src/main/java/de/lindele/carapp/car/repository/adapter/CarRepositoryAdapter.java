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

// TODO implement methods
@Repository
@RequiredArgsConstructor
public class CarRepositoryAdapter implements CarPersistencePort {

  private final CarRepository carRepository;
  private final CarEntityMapper carEntityMapper;

  public Page<Car> findAllCarsByBrand(String brand, Pageable pageable) {
    return carRepository.findByBrand(brand, pageable).map(carEntityMapper::map);
  }

  @Override
  public Page<Car> findAllCars(Pageable pageable) {
    return carRepository.findAll(pageable).map(carEntityMapper::map);
  }

  @Override
  public Car findCarById(Long id) {
    return carRepository.findById(id).map(carEntityMapper::map).orElse(null);
  }

  @Override
  public Page<Car> findAllCarsByColor(String color, Pageable pageable) {
    return carRepository.findAllByColor(color, pageable).map(carEntityMapper::map);
  }

  @Override
  public Page<Car> findAllCarsByBrandAndColor(String brand, String color, Pageable pageable) {
    return carRepository.findAllByBrandAndColor(brand, color, pageable).map(carEntityMapper::map);
  }

  @Override
  public Car saveCar(Car car) {
    CarEntity savedCar = carRepository.save(carEntityMapper.map(car));
    return carEntityMapper.map(savedCar);
  }

  @Override
  public Car updateCar(Car car, Long id) {
    Optional<CarEntity> savedCar = carRepository.findById(id);
    if (savedCar.isPresent()) {
      CarEntity savedEntity = savedCar.get();
      BeanUtils.copyProperties(car, savedEntity, "id");
      return carEntityMapper.map(carRepository.save(savedEntity));
    } else throw new ResourceNotFoundException("Car not found with id: " + id);
  }

  @Override
  public void deleteCar(Long id) {
    if (carRepository.existsById(id)) {
      carRepository.deleteById(id);
    } else throw new ResourceNotFoundException("Car not found with id: " + id);
  }
}
