package de.lindele.carapp.rental.repository.adapter;

import de.lindele.carapp.rental.repository.model.RentalEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<RentalEntity, Long> {

  Page<RentalEntity> findAllByCarId(Long carId, Pageable pageable);

  Page<RentalEntity> findAllByCustomerId(Long customerId, Pageable pageable);
}
