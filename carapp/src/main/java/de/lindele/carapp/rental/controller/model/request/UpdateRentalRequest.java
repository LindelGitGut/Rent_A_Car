package de.lindele.carapp.rental.controller.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

// TODO implement Request


@Data
@Builder
public class UpdateRentalRequest {

    @NotNull Long userId;
    @NotNull Long carId;
    @NotNull Date startDate;
    @NotNull Date endDate;
    @NotNull int kilometersDriven;

}
