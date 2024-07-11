package de.lindele.carapp.car.controller;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

import de.lindele.carapp.car.controller.model.request.CreateCarRequest;
import de.lindele.carapp.car.repository.adapter.CarRepository;
import de.lindele.carapp.car.repository.model.CarEntity;
import java.math.BigDecimal;

import de.lindele.carapp.car.service.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarControllerIntegrationTest {

  @LocalServerPort private int port;

  @BeforeEach
  void setUp() {
    // Konfiguriert RestAssured, den dynamischen Port zu verwenden
    io.restassured.RestAssured.port = port;
  }

  @Autowired private CarRepository carRepository;

  @Test
  void createCar() {

        CreateCarRequest request =  CreateCarRequest.builder()
                .kilometer(1000)
                .pricePerKilometer(new BigDecimal("1.5"))
                .brand("brand")
                .model("model")
                .color("color")
                .registrationNumber("registrationNumber")
                .build();

//        CarEntity.builder()
//            .color("color")
//            .kilometer(100)
//            .pricePerKilometer(new BigDecimal(100))
//            .brand("brand")
//            .model("model")
//            .registrationNumber("registrationNumber")
//            .build();



    given()
        // .auth().oauth2("jwtpass")
        .contentType("application/json")
        .body(request)
        .when()
        .post("/car")
        .then()
        .statusCode(201);

  }

  @Test
  void getCar() {
    CarEntity entity =
        CarEntity.builder()
            .color("color")
            .kilometer(100)
            .pricePerKilometer(new BigDecimal(100))
            .brand("brand")
            .model("model")
            .registrationNumber("registrationNumber")
            .build();
    CarEntity savedEntity = carRepository.save(entity);

    given()
        // .auth().oauth2("jwtpass")
        .when()
        .get("/car/" + savedEntity.getId())
        .then()
        .statusCode(200);

    carRepository.delete(savedEntity);
  }

  @Test
  void getAllCars() {}

  @Test
  void updateCar() {}

  @Test
  void deleteCar() {}
}
