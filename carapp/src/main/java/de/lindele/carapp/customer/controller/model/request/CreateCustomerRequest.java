package de.lindele.carapp.customer.controller.model.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

//TODO Implement

@AllArgsConstructor
@Getter
@Setter
public class CreateCustomerRequest {

    @NotNull
    @NotBlank
    private String firstname;

    @NotNull
    @NotBlank
    private String lastname;

    @NotNull
    @NotBlank
    private String address;

    @NotNull
    private Date birthdate;

    @NotNull
    @NotBlank
    private String city;
    @NotNull
    @NotBlank
    private String postalCode;

    @NotNull
    @NotBlank
    private String phoneNumber;

    @NotNull
    @NotBlank
    private String email;
}
