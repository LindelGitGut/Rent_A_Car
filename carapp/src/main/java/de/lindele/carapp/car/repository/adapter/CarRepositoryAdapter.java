package de.lindele.carapp.car.repository.adapter;


import de.lindele.carapp.car.repository.mapper.CarEntityMapper;
import de.lindele.carapp.car.service.model.Car;
import de.lindele.carapp.car.service.port.CarPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


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
        return null;
    }

    @Override
    public Car findCarById(Long id) {
        return null;
    }

    @Override
    public Car findAllCarsByColor(String color) {
        return null;
    }


}
