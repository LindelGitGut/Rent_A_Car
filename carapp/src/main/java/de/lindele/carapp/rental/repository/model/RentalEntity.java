package de.lindele.carapp.rental.repository.model;

import de.lindele.carapp.car.repository.model.CarEntity;
import de.lindele.carapp.customer.repository.model.CustomerEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private CarEntity car;

    @Temporal(TemporalType.DATE)
    private Date rentalDate;

    @Temporal(TemporalType.DATE)
    private Date returnDate;

    private int kilometersDriven;
}