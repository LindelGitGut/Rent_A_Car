package de.lindele.carapp.car.service;

import de.lindele.carapp.car.service.model.Car;
import de.lindele.carapp.car.service.port.CarPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

  @Mock private CarPersistencePort carPersistencePort;
  @InjectMocks private CarService carService;

  @Test
  void createCar() {
    var car = new Car();

    Mockito.when(carPersistencePort.saveCar(car)).thenReturn(car);

    carService.createCar(car);

    Mockito.verify(carPersistencePort, Mockito.times(1)).saveCar(car);
  }

  @Test
  void getAllCarsByBrand() {}

  @Test
  void getAllCarsByColor() {}

  @Test
  void getAllCarsByBrandAndColor() {}

  @Test
  void getAllCars() {}

  @Test
  void updateCar() {}

  @Test
  void deleteCar() {}

  @Test
  void getCarById() {}
}
