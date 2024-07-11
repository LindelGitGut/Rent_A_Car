package de.lindele.carapp.rental.service.model;


import de.lindele.carapp.car.service.model.Car;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Rental {

    private Long id;
    private Long customerId;
    private Car car;
    private Date rentalDate;
    private Date returnDate;
    private Integer kilometers;


}
