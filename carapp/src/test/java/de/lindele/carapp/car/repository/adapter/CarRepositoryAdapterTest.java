package de.lindele.carapp.car.repository.adapter;

import static org.junit.jupiter.api.Assertions.*;

import de.lindele.carapp.car.repository.mapper.CarEntityMapper;
import de.lindele.carapp.car.repository.model.CarEntity;
import de.lindele.carapp.car.service.model.Car;
import de.lindele.carapp.rental.repository.model.RentalEntity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@ExtendWith(MockitoExtension.class)
class CarRepositoryAdapterTest {

  @Mock CarRepository carRepository;
  @Spy CarEntityMapper carEntityMapper;
  @InjectMocks CarRepositoryAdapter carRepositoryAdapter;

  @Test
  void findAllCarsByBrand() {

    List<CarEntity> carEntities =
        List.of(
            CarEntity.builder()
                .id(1L)
                .brand("Toyota")
                .model("Corolla")
                .color("Blue")
                .registrationNumber("ABC123")
                .kilometer(50000)
                .pricePerKilometer(new BigDecimal("0.5"))
                .build(),
            CarEntity.builder()
                .id(2L)
                .brand("Toyota")
                .model("Camry")
                .color("Red")
                .registrationNumber("XYZ789")
                .kilometer(30000)
                .pricePerKilometer(new BigDecimal("0.7"))
                .build());

    // Verwendung einer spezifischen Pageable-Instanz für die Paginierung
    Pageable pageable = PageRequest.of(0, 5); // Seite 0, 5 Einträge pro Seite

    // Erzeugt ein Page-Objekt, das die Liste der CarEntity-Objekte enthält
    Page<CarEntity> carEntityPage = new PageImpl<>(carEntities, pageable, carEntities.size());

    // Mocking des Verhaltens des Repositories
    Mockito.when(carRepository.findByBrand("Toyota", pageable)).thenReturn(carEntityPage);

    // Aufruf der zu testenden Methode
    Page<Car> cars = carRepositoryAdapter.findAllCarsByBrand("Toyota", pageable);

    // Überprüfung der Ergebnisse
    assertNotNull(cars);
    assertEquals(2, cars.getTotalElements());

    Mockito.verify(carRepository, Mockito.times(1)).findByBrand("Toyota", pageable);
    Mockito.verify(carEntityMapper, Mockito.times(2)).map(Mockito.any(CarEntity.class));

    // Stellt die gewünschten ergebnisse der Liste dar
    List<Car> expectedCars =
        List.of(
            Car.builder()
                .id(1L)
                .brand("Toyota")
                .model("Corolla")
                .color("Blue")
                .registrationNumber("ABC123")
                .drivenkilometers(50000)
                .pricePerKilometer(new BigDecimal("0.5"))
                .build(),
            Car.builder()
                .id(2L)
                .brand("Toyota")
                .model("Camry")
                .color("Red")
                .registrationNumber("XYZ789")
                .drivenkilometers(30000)
                .pricePerKilometer(new BigDecimal("0.7"))
                .build());
    assertEquals(expectedCars, cars.getContent());
  }

  @Test
  void findAllCars() {

    List<CarEntity> carEntities =
        List.of(
            CarEntity.builder()
                .id(1L)
                .brand("Toyota")
                .model("Corolla")
                .color("Blue")
                .registrationNumber("ABC123")
                .kilometer(50000)
                .pricePerKilometer(new BigDecimal("0.5"))
                .build(),
            CarEntity.builder()
                .id(2L)
                .brand("Toyota")
                .model("Camry")
                .color("Red")
                .registrationNumber("XYZ789")
                .kilometer(30000)
                .pricePerKilometer(new BigDecimal("0.7"))
                .build());

    // Verwendung einer spezifischen Pageable-Instanz für die Paginierung
    Pageable pageable = PageRequest.of(0, 5); // Seite 0, 5 Einträge pro Seite

    // Erzeugt ein Page-Objekt, das die Liste der CarEntity-Objekte enthält
    Page<CarEntity> carEntityPage = new PageImpl<>(carEntities, pageable, carEntities.size());

    // Mocking des Verhaltens des Repositories
    Mockito.when(carRepository.findAll(pageable)).thenReturn(carEntityPage);

    // Aufruf der zu testenden Methode
    Page<Car> cars = carRepositoryAdapter.findAllCars(pageable);

    // Überprüfung der Ergebnisse
    assertNotNull(cars);
    assertEquals(2, cars.getTotalElements());

    Mockito.verify(carRepository, Mockito.times(1)).findAll(pageable);
    Mockito.verify(carEntityMapper, Mockito.times(2)).map(Mockito.any(CarEntity.class));

    // Stellt die gewünschten ergebnisse der Liste dar
    List<Car> expectedCars =
        List.of(
            Car.builder()
                .id(1L)
                .brand("Toyota")
                .model("Corolla")
                .color("Blue")
                .registrationNumber("ABC123")
                .drivenkilometers(50000)
                .pricePerKilometer(new BigDecimal("0.5"))
                .build(),
            Car.builder()
                .id(2L)
                .brand("Toyota")
                .model("Camry")
                .color("Red")
                .registrationNumber("XYZ789")
                .drivenkilometers(30000)
                .pricePerKilometer(new BigDecimal("0.7"))
                .build());

    assertEquals(expectedCars, cars.getContent());
  }

  @Test
  void findCarById() {

    CarEntity carEntity =
        CarEntity.builder()
            .id(1L)
            .brand("Toyota")
            .model("Corolla")
            .color("Blue")
            .registrationNumber("ABC123")
            .kilometer(50000)
            .pricePerKilometer(new BigDecimal("0.5"))
            .build();

    // Mocking des Verhaltens des Repositories
    Mockito.when(carRepository.findById(1L)).thenReturn(java.util.Optional.of(carEntity));

    // Aufruf der zu testenden Methode
    Car car = carRepositoryAdapter.findCarById(1L);

    // Überprüfung der Ergebnisse
    assertNotNull(car);
    Mockito.verify(carRepository, Mockito.times(1)).findById(1L);
    Mockito.verify(carEntityMapper, Mockito.times(1)).map(carEntity);

    Car expectedCar =
        Car.builder()
            .id(1L)
            .brand("Toyota")
            .model("Corolla")
            .color("Blue")
            .registrationNumber("ABC123")
            .drivenkilometers(50000)
            .pricePerKilometer(new BigDecimal("0.5"))
            .build();

    assertEquals(expectedCar, car);
  }

  @Test
  void findAllCarsByColor() {
    List<CarEntity> carEntities =
        List.of(
            CarEntity.builder()
                .id(1L)
                .brand("Toyota")
                .model("Corolla")
                .color("Red")
                .registrationNumber("ABC123")
                .kilometer(50000)
                .pricePerKilometer(new BigDecimal("0.5"))
                .build(),
            CarEntity.builder()
                .id(2L)
                .brand("Toyota")
                .model("Camry")
                .color("Red")
                .registrationNumber("XYZ789")
                .kilometer(30000)
                .pricePerKilometer(new BigDecimal("0.7"))
                .build());

    // Verwendung einer spezifischen Pageable-Instanz für die Paginierung
    Pageable pageable = PageRequest.of(0, 5); // Seite 0, 5 Einträge pro Seite

    // Erzeugt ein Page-Objekt, das die Liste der CarEntity-Objekte enthält
    Page<CarEntity> carEntityPage = new PageImpl<>(carEntities, pageable, carEntities.size());

    // Mocking des Verhaltens des Repositories
    Mockito.when(carRepository.findAllByColor("Red", pageable)).thenReturn(carEntityPage);

    // Aufruf der zu testenden Methode
    Page<Car> cars = carRepositoryAdapter.findAllCarsByColor("Red", pageable);

    // Überprüfung der Ergebnisse
    assertNotNull(cars);
    assertEquals(2, cars.getTotalElements());

    Mockito.verify(carRepository, Mockito.times(1)).findAllByColor("Red", pageable);
    Mockito.verify(carEntityMapper, Mockito.times(2)).map(Mockito.any(CarEntity.class));

    // Stellt die gewünschten ergebnisse der Liste dar
    List<Car> expectedCars =
        List.of(
            Car.builder()
                .id(1L)
                .brand("Toyota")
                .model("Corolla")
                .color("Red")
                .registrationNumber("ABC123")
                .drivenkilometers(50000)
                .pricePerKilometer(new BigDecimal("0.5"))
                .build(),
            Car.builder()
                .id(2L)
                .brand("Toyota")
                .model("Camry")
                .color("Red")
                .registrationNumber("XYZ789")
                .drivenkilometers(30000)
                .pricePerKilometer(new BigDecimal("0.7"))
                .build());

    // Vergleicht die erwarteten Ergebnisse mit den tatsächlichen Ergebnissen
    assertEquals(expectedCars, cars.getContent());
  }

  @Test
  void findAllCarsByBrandAndColor() {

    List<CarEntity> carEntities =
        List.of(
            CarEntity.builder()
                .id(1L)
                .brand("Toyota")
                .model("Corolla")
                .color("Red")
                .registrationNumber("ABC123")
                .kilometer(50000)
                .pricePerKilometer(new BigDecimal("0.5"))
                .build(),
            CarEntity.builder()
                .id(2L)
                .brand("Toyota")
                .model("Camry")
                .color("Red")
                .registrationNumber("XYZ789")
                .kilometer(30000)
                .pricePerKilometer(new BigDecimal("0.7"))
                .build());

    // Verwendung einer spezifischen Pageable-Instanz für die Paginierung
    Pageable pageable = PageRequest.of(0, 5); // Seite 0, 5 Einträge pro Seite

    // Erzeugt ein Page-Objekt, das die Liste der CarEntity-Objekte enthält
    Page<CarEntity> carEntityPage = new PageImpl<>(carEntities, pageable, carEntities.size());

    // Mocking des Verhaltens des Repositories
    Mockito.when(carRepository.findAllByBrandAndColor("Toyota", "Red", pageable))
        .thenReturn(carEntityPage);

    // Aufruf der zu testenden Methode
    Page<Car> cars = carRepositoryAdapter.findAllCarsByBrandAndColor("Toyota", "Red", pageable);

    // Überprüfung der Ergebnisse
    assertNotNull(cars);
    assertEquals(2, cars.getTotalElements());

    Mockito.verify(carRepository, Mockito.times(1))
        .findAllByBrandAndColor("Toyota", "Red", pageable);
    Mockito.verify(carEntityMapper, Mockito.times(2)).map(Mockito.any(CarEntity.class));

    // Stellt die gewünschten ergebnisse der Liste dar
    List<Car> expectedCars =
        List.of(
            Car.builder()
                .id(1L)
                .brand("Toyota")
                .model("Corolla")
                .color("Red")
                .registrationNumber("ABC123")
                .drivenkilometers(50000)
                .pricePerKilometer(new BigDecimal("0.5"))
                .build(),
            Car.builder()
                .id(2L)
                .brand("Toyota")
                .model("Camry")
                .color("Red")
                .registrationNumber("XYZ789")
                .drivenkilometers(30000)
                .pricePerKilometer(new BigDecimal("0.7"))
                .build());

    // Vergleicht die erwarteten Ergebnisse mit den tatsächlichen Ergebnissen
    assertEquals(expectedCars, cars.getContent());
  }

  @Test
  void saveCar() {
    var car =
        Car.builder()
            .brand("brand")
            .model("model")
            .color("color")
            .registrationNumber("registrationNumber")
            .drivenkilometers(1000)
            .pricePerKilometer(new BigDecimal("1.5"))
            .build();

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
              CarEntity entity =
                  invocation.getArgument(
                      0); // Setzt die ID, um das Verhalten des Speicherns in der Datenbank zu
              // simulieren
              entity.setId(1L);
              return entity;
            });

    carRepositoryAdapter.saveCar(car);

    Mockito.verify(carRepository, Mockito.times(1)).save(savedCarEntity);
    Mockito.verify(carEntityMapper, Mockito.times(1)).map(car);
  }

  @Test
  void updateCar() {
    var car =
        Car.builder()
            .id(1L)
            .brand("brand")
            .model("model")
            .color("color")
            .registrationNumber("registrationNumber")
            .drivenkilometers(1000)
            .pricePerKilometer(new BigDecimal("1.5"))
            .build();

    var oldCarEntity =
        CarEntity.builder()
            .id(1L)
            .brand("oldBrand")
            .color("oldColor")
            .model("oldModel")
            .registrationNumber("oldRegistrationNumber")
            .kilometer(1000)
            .pricePerKilometer(new BigDecimal("1.5"))
            .rentals(new ArrayList<RentalEntity>())
            .build();

    var carEntity =
        CarEntity.builder()
            .id(1L)
            .brand(car.getBrand())
            .color(car.getColor())
            .model(car.getModel())
            .registrationNumber(car.getRegistrationNumber())
            .kilometer(car.getDrivenkilometers())
            .pricePerKilometer(car.getPricePerKilometer())
            .rentals(new ArrayList<RentalEntity>())
            .build();

    Mockito.when(carRepository.findById(car.getId()))
        .thenReturn(java.util.Optional.of(oldCarEntity));
    Mockito.when(carRepository.save(carEntity)).thenReturn(carEntity);

    var newCar = carRepositoryAdapter.updateCar(car);

    Mockito.verify(carRepository, Mockito.times(1)).findById(car.getId());
    Mockito.verify(carRepository, Mockito.times(1)).save(carEntity);
    Mockito.verify(carEntityMapper, Mockito.times(1)).map(Mockito.any(CarEntity.class));

    Car expectedCar =
        Car.builder()
            .id(1L)
            .brand("brand")
            .model("model")
            .color("color")
            .registrationNumber("registrationNumber")
            .drivenkilometers(1000)
            .pricePerKilometer(new BigDecimal("1.5"))
            .build();

    assertEquals(expectedCar, newCar);
  }

  @Test
  void deleteCar() {
    Mockito.when(carRepository.existsById(1L)).thenReturn(true);

    carRepositoryAdapter.deleteCar(1L);

    Mockito.verify(carRepository, Mockito.times(1)).deleteById(1L);
  }
}
