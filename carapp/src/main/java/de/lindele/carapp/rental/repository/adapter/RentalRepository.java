package de.lindele.carapp.rental.repository.adapter;

import de.lindele.carapp.rental.repository.model.RentalEntity;
import java.sql.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RentalRepository extends JpaRepository<RentalEntity, Long> {

  @Query(
      "SELECT CASE WHEN COUNT(r) > 0 THEN TRUE ELSE FALSE END FROM RentalEntity r WHERE r.car.id = :carId AND r.rentalEnd >= :startDate AND r.rentalStart <= :endDate")
  boolean existsByCarIdAndDateRange(
      @Param("carId") Long carId,
      @Param("startDate") Date startDate,
      @Param("endDate") Date endDate);

  Page<RentalEntity> findAllByCarId(Long carId, Pageable pageable);

  Page<RentalEntity> findAllByCustomerId(Long customerId, Pageable pageable);
}
