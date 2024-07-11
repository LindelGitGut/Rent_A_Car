package de.lindele.carapp.rental.repository.mapper;

import de.lindele.carapp.car.controller.mapper.CarWebModelMapper;
import de.lindele.carapp.car.repository.mapper.CarEntityMapper;
import de.lindele.carapp.car.repository.model.CarEntity;
import de.lindele.carapp.customer.repository.model.CustomerEntity;
import de.lindele.carapp.rental.repository.model.RentalEntity;
import de.lindele.carapp.rental.service.model.Rental;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//TODO fix Customer Mapping


@Component
@RequiredArgsConstructor
public class RentalEntityMapper {


    private final CarEntityMapper carEntityMapper;

    public  Rental entityToModel(RentalEntity entity) {
        Rental model = new Rental();
        model.setId(entity.getId());
        //model.setCustomerId(entity.getCustomer().get());

        model.setCar(carEntityMapper.map(entity.getCar()));
        model.setRentalDate(entity.getRentalDate());
        model.setReturnDate(entity.getReturnDate());
        model.setKilometers(entity.getKilometers());
        return model;
    }

    public  RentalEntity modelToEntity(Rental model, CustomerEntity customer, CarEntity car) {
        RentalEntity entity = new RentalEntity();
        entity.setId(model.getId());
       // entity.setCustomer(customer);
        entity.setCar(car);
        entity.setRentalDate(model.getRentalDate());
        entity.setReturnDate(model.getReturnDate());
        //entity.setKilometersDriven(model.getKilometersDriven());
        return entity;
    }
}