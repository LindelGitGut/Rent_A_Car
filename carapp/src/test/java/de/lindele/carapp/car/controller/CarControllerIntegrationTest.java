package de.lindele.carapp.car.controller;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

import de.lindele.carapp.car.controller.model.request.CreateCarRequest;
import de.lindele.carapp.car.controller.model.request.UpdateCarRequest;
import de.lindele.carapp.car.repository.adapter.CarRepository;
import de.lindele.carapp.car.repository.model.CarEntity;
import java.math.BigDecimal;
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
    carRepository.deleteAll();
  }

  @Autowired private CarRepository carRepository;

  @Test
  void createCar() {

    CreateCarRequest request =
        CreateCarRequest.builder()
            .kilometer(1000)
            .pricePerKilometer(new BigDecimal("1.5"))
            .brand("brand")
            .model("model")
            .color("color")
            .registrationNumber("registrationNumber")
            .build();

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

  }

  @Test
  void getAllCars() {
    CarEntity carEntity1 =
        CarEntity.builder()
            .color("color")
            .kilometer(100)
            .pricePerKilometer(new BigDecimal(100))
            .brand("brand")
            .model("model")
            .registrationNumber("registrationNumber")
            .build();

    CarEntity carEntity2 =
        CarEntity.builder()
            .color("color")
            .kilometer(100)
            .pricePerKilometer(new BigDecimal(100))
            .brand("brand")
            .model("model")
            .registrationNumber("registrationNumber")
            .build();

    carRepository.save(carEntity1);
    carRepository.save(carEntity2);

    given()
        // .auth().oauth2("jwtpass")
        .when()
        .get("/car")
        .then()
        .statusCode(200)
                .body("content.size()", org.hamcrest.Matchers.equalTo(2));

  }

  @Test
  void updateCar() {

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

    UpdateCarRequest request =
        UpdateCarRequest.builder()
            .kilometer(1000)
            .pricePerKilometer(new BigDecimal("1.5"))
            .brand("brand")
            .model("model")
            .color("color")
            .registrationNumber("registrationNumber")
            .build();

    given()
        // .auth().oauth2("jwtpass")
        .contentType("application/json")
        .body(request)
        .when()
        .put("/car/" + savedEntity.getId())
        .then()
        .statusCode(200);

    savedEntity = carRepository.findById(1L).get();


  }

  @Test
  void deleteCar() {
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
        .delete("/car/" + savedEntity.getId())
        .then()
        .statusCode(204); // No Content
  }
}
