package de.lindele.carapp.rental.controller.model.request;

import jakarta.validation.constraints.NotNull;
import java.sql.Date;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateRentalRequest {
  @NotNull Long userId;
  @NotNull Long carId;
  @NotNull Date startDate;
  @NotNull Date endDate;
}
