package de.lindele.carapp.rental.service.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Rental {

    private Long id;
    private Long customerId;
    private Long carId;
    private Date rentalDate;
    private Date returnDate;
    private Integer kilometers;


}
