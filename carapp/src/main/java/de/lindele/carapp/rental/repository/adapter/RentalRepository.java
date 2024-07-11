package de.lindele.carapp.rental.repository.adapter;

import de.lindele.carapp.rental.repository.model.RentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<RentalEntity, Long> {}
