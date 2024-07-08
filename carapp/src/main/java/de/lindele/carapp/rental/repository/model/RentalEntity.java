package de.lindele.carapp.rental.repository.model;

import de.lindele.carapp.car.repository.model.CarEntity;
import de.lindele.carapp.customer.service.model.Customer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class RentalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private CarEntity car;

    @Temporal(TemporalType.DATE)
    private Date rentalDate;

    @Temporal(TemporalType.DATE)
    private Date returnDate;

    private int kilometers;

}