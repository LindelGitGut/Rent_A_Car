package de.lindele.carapp.customer.controller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;


@NoArgsConstructor
@Getter
@Setter
public class CustomerWebModel {

    private String firstname;
    private String lastname;
    private String address;
    private Date birthdate;
    private String city;
    private String postalCode;
    private String phoneNumber;
    private String email;


}
