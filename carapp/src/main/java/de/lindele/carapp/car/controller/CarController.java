package de.lindele.carapp.car.controller;


import de.lindele.carapp.car.controller.mapper.CarWebModelMapper;
import de.lindele.carapp.car.controller.mapper.CreateCarRequestMapper;
import de.lindele.carapp.car.controller.model.CarWebModel;
import de.lindele.carapp.car.controller.model.request.CreateCarRequest;
import de.lindele.carapp.car.service.CarService;
import de.lindele.carapp.car.service.model.Car;
//import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
//@Api(value = "Car Management System")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarWebModelMapper carWebModelMapper;

    @Autowired
    private CreateCarRequestMapper createCarRequestMapper;




    //TODO Implement and extend CRUD-Endpoints
    //CREATE

    //Funktioniert
    @PostMapping
    ResponseEntity<CarWebModel> createCar(
            @RequestBody CreateCarRequest createCarRequest) {
        //convert CarWebModel to Car
        Car car = createCarRequestMapper.map(createCarRequest);
        //create car and return CarWebModel
        return ResponseEntity.ok(carWebModelMapper.map(carService.createCar(car)));
    }

    //READ

    //Funktioniert
    @GetMapping("/{id}")
    ResponseEntity<CarWebModel> getCar(@PathVariable Long id) {
        return ResponseEntity.ok(carWebModelMapper.map(carService.getCarById(id)));
    }

    //Funktioniert?
    @GetMapping
    ResponseEntity<Page<CarWebModel>> getAllCars(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String color,
            @PageableDefault(size = 10) Pageable pageable
    ) {

        Page<Car> cars;

        if(StringUtils.hasText(brand) && StringUtils.hasText(color)){
            cars = carService.getAllCarsByBrandAndColor(brand, color, pageable);
            return ResponseEntity.ok(cars.map(carWebModelMapper::map));
        }

        if (StringUtils.hasText(brand)) {
            cars = carService.getAllCarsByBrand(brand, pageable);
            return ResponseEntity.ok(cars.map(carWebModelMapper::map));
        }

        if (StringUtils.hasText(color)) {
            cars = carService.getAllCarsByColor(color, pageable);
            return ResponseEntity.ok(cars.map(carWebModelMapper::map));
        }

        cars = carService.getAllCars(pageable);
        return ResponseEntity.ok(cars.map(carWebModelMapper::map));
    }

    //UPDATE
    @PutMapping
     ResponseEntity<CarWebModel> updateCar(
             @RequestBody CarWebModel carWebModel,
            @RequestParam(required = true
            ) Long id) {
        //convert CarWebModel to Car
        Car car = carWebModelMapper.map(carWebModel);
        //update car and return CarWebModel
        return ResponseEntity.ok(carWebModelMapper.map(carService.updateCar(car)));
    }
    //DELETE
    @DeleteMapping
     ResponseEntity<CarWebModel> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }

}
