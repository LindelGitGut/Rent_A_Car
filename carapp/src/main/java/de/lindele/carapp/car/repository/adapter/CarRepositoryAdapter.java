package de.lindele.carapp.car.repository.adapter;


import de.lindele.carapp.car.repository.mapper.CarEntityMapper;
import de.lindele.carapp.car.repository.model.CarEntity;
import de.lindele.carapp.car.service.model.Car;
import de.lindele.carapp.car.service.port.CarPersistencePort;
import de.lindele.carapp.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//TODO implement methods
@Repository
@RequiredArgsConstructor
public class CarRepositoryAdapter implements CarPersistencePort {

    private final CarRepository carRepository;
    private final CarEntityMapper carEntityMapper;

    public Page<Car> findCarByBrand(String brand, Pageable pageable) {
        return carRepository.findByBrand(brand, pageable)
                .map(carEntityMapper::map);
    }

    @Override
    public Page<Car> findAllCars(Pageable pageable) {
        return carRepository.findAll(pageable)
                .map(carEntityMapper::map);
    }

    @Override
    public Car findCarById(Long id) {
        return carRepository.findById(id)
                .map(carEntityMapper::map)
                .orElse(null);
    }

    @Override
    public Page<Car> findAllCarsByColor(String color, Pageable pageable) {
        return carRepository.findByColor(color, pageable)
                .map(carEntityMapper::map);
    }

    @Override
    public Page<Car> findAllCarsByBrandAndColor(String brand, String color, Pageable pageable) {
        return carRepository.findByBrandAndColor(brand, color, pageable)
                .map(carEntityMapper::map);
    }

    @Override
    public Car saveCar(Car car) {
        CarEntity savedCar = carRepository.save(carEntityMapper.map(car));
        return carEntityMapper.map(savedCar);
    }

    @Override
    public Car updateCar(Car car, Long id) {
        Optional<CarEntity> savedCar = carRepository.findById(id);
        if (savedCar.isPresent()){
            CarEntity updatedCar = carEntityMapper.map(car);
            updatedCar.setId(id);
            return carEntityMapper.map(carRepository.save(updatedCar));
        }
        else throw new ResourceNotFoundException("Car not found with id: " + id);
    }

    @Override
    public void deleteCar(Long id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
        }
        else throw new ResourceNotFoundException("Car not found with id: " + id);
    }




}
