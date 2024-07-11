package de.lindele.carapp.car.repository.adapter;

import static org.junit.jupiter.api.Assertions.*;

import de.lindele.carapp.car.repository.mapper.CarEntityMapper;
import de.lindele.carapp.car.repository.model.CarEntity;
import de.lindele.carapp.car.service.model.Car;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CarRepositoryAdapterTest {

  @Mock CarRepository carRepository;
  @Spy CarEntityMapper carEntityMapper;
  @InjectMocks CarRepositoryAdapter carRepositoryAdapter;

  @Test
  void findCarByBrand() {}

  @Test
  void findAllCars() {}

  @Test
  void findCarById() {}

  @Test
  void findAllCarsByColor() {}

  @Test
  void findAllCarsByBrandAndColor() {}

  @Test
  void saveCar() {
    var car = new Car("brand", "model", "color", "registrationNumber", 100, new BigDecimal("0.5"));
    var carEntity =
        CarEntity.builder()
            .brand(car.getBrand())
            .color(car.getColor())
            .model(car.getModel())
            .registrationNumber(car.getRegistrationNumber())
            .kilometer(car.getDrivenkilometers())
            .pricePerKilometer(car.getPricePerKilometer())
            .build();
    var savedCarEntity = carEntity.toBuilder().id(1L).build();

    Mockito.when(carRepository.save(carEntity))
        .thenAnswer(
            invocation -> {
              CarEntity entity = invocation.getArgument(0);
              entity.setId(1L);
              return entity;
            });

    carRepositoryAdapter.saveCar(car);

    Mockito.verify(carRepository, Mockito.times(1)).save(savedCarEntity);
    Mockito.verify(carEntityMapper, Mockito.times(1)).map(car);
  }

  @Test
  void updateCar() {}

  @Test
  void deleteCar() {}
}
