package de.lindele.carapp.car.service;

import de.lindele.carapp.car.service.model.Car;
import de.lindele.carapp.car.service.port.CarPersistencePort;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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
  void getAllCarsByBrand() {

    Car car1 = Car.builder().build(); // Set properties as needed
    Car car2 = Car.builder().build();

    List<Car> carList = Arrays.asList(car1, car2);

    // da wir eine Page zurückgeben, müssen wir eine Page erstellen
    Page<Car> carPage = new PageImpl<>(carList);

    // da wir mit Pageable arbeiten müssen wir ein Pageable mitgeben um die Anzahl an Ergebnissen zu
    // begrenzen

    Pageable pageable = PageRequest.of(0, 10);

    Mockito.when(carPersistencePort.findAllCarsByBrand("brand", pageable)).thenReturn(carPage);

    carService.getAllCarsByBrand("brand", pageable);

    Mockito.verify(carPersistencePort, Mockito.times(1)).findAllCarsByBrand("brand", pageable);
  }

  @Test
  void getAllCarsByColor() {

    Car car1 = Car.builder().build(); // Set properties as needed
    Car car2 = Car.builder().build();

    List<Car> carList = Arrays.asList(car1, car2);

    // da wir eine Page zurückgeben, müssen wir eine Page erstellen
    Page<Car> carPage = new PageImpl<>(carList);

    // da wir mit Pageable arbeiten müssen wir ein Pageable mitgeben um die Anzahl an Ergebnissen zu
    // begrenzen

    Pageable pageable = PageRequest.of(0, 10);

    Mockito.when(carPersistencePort.findAllCarsByColor("color", pageable)).thenReturn(carPage);

    carService.getAllCarsByColor("color", pageable);

    Mockito.verify(carPersistencePort, Mockito.times(1)).findAllCarsByColor("color", pageable);
  }

  @Test
  void getAllCarsByBrandAndColor() {

    Car car1 = Car.builder().build(); // Set properties as needed
    Car car2 = Car.builder().build();

    List<Car> carList = Arrays.asList(car1, car2);

    // da wir eine Page zurückgeben, müssen wir eine Page erstellen
    Page<Car> carPage = new PageImpl<>(carList);

    // da wir mit Pageable arbeiten müssen wir ein Pageable mitgeben um die Anzahl an Ergebnissen zu
    // begrenzen

    Pageable pageable = PageRequest.of(0, 10);

    Mockito.when(carPersistencePort.findAllCarsByBrandAndColor("brand", "color", pageable))
        .thenReturn(carPage);

    carService.getAllCarsByBrandAndColor("brand", "color", pageable);

    Mockito.verify(carPersistencePort, Mockito.times(1))
        .findAllCarsByBrandAndColor("brand", "color", pageable);
  }

  @Test
  void getAllCars() {

    Car car1 = Car.builder().build(); // Set properties as needed
    Car car2 = Car.builder().build();

    List<Car> carList = Arrays.asList(car1, car2);

    // da wir eine Page zurückgeben, müssen wir eine Page erstellen
    Page<Car> carPage = new PageImpl<>(carList);

    // da wir mit Pageable arbeiten müssen wir ein Pageable mitgeben um die Anzahl an Ergebnissen zu
    // begrenzen

    Pageable pageable = PageRequest.of(0, 10);

    Mockito.when(carPersistencePort.findAllCars(pageable)).thenReturn(carPage);

    carService.getAllCars(pageable);

    Mockito.verify(carPersistencePort, Mockito.times(1)).findAllCars(pageable);
  }

  @Test
  void updateCar() {

    Car car = Car.builder().id(1L).build();

    Mockito.when(carPersistencePort.updateCar(car)).thenReturn(car);

    carService.updateCar(car);

    Mockito.verify(carPersistencePort, Mockito.times(1)).updateCar(car);
  }

  @Test
  void deleteCar() {

    Car car = Car.builder().id(1L).build();

    Mockito.doNothing().when(carPersistencePort).deleteCar(car.getId());

    carService.deleteCar(car.getId());

    Mockito.verify(carPersistencePort, Mockito.times(1)).deleteCar(car.getId());
  }

  @Test
  void getCarById() {

    Car car = Car.builder().id(1L).build();

    Mockito.when(carPersistencePort.findCarById(1L)).thenReturn(car);

    carService.getCarById(car.getId());

    Mockito.verify(carPersistencePort, Mockito.times(1)).findCarById(1L);
  }
}
