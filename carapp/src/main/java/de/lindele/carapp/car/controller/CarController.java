package de.lindele.carapp.car.controller;


import de.lindele.carapp.car.controller.model.CarWebModel;
import de.lindele.carapp.car.service.CarService;
import de.lindele.carapp.car.service.model.Car;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/car")
@Api(value = "Car Management System")
public class CarController {

    @Autowired
    CarService carService;




    //TODO Implement and extend CRUD-Endpoints
    //CREATE

    @PostMapping
    <CarWebModel> ResponseEntity<CarWebModel> createCar(@RequestBody CarWebModel carWebModel) {
        return ResponseEntity.ok(carService.createCar(carWebModel));
    }


    //READ
    @GetMapping
    <CarWebModel> ResponseEntity<CarWebModel> getCar(@PathVariable Long id) {
        return ResponseEntity.ok(carService.getCar(id));
    }
    //UPDATE
    @PutMapping
    <CarWebModel> ResponseEntity<CarWebModel> updateCar(@RequestBody CarWebModel carWebModel) {
        return ResponseEntity.ok(carService.updateCar(carWebModel));
    }
    //DELETE
    @DeleteMapping
    <CarWebModel> ResponseEntity<CarWebModel> deleteCar(@PathVariable Long id) {
        return ResponseEntity.ok(carService.deleteCar(id));
    }

    CarWebModel convertCarToCarWebModel(Car car) {
        //TODO Implement
        return null;
    }

    Car convertCarWebModelToCar(CarWebModel carWebModel) {
        //TODO Implement
        return null;
    }
}
