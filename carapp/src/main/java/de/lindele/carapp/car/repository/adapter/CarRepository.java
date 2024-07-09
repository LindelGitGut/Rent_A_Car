package de.lindele.carapp.car.repository.adapter;


import de.lindele.carapp.car.repository.mapper.CarEntityMapper;
import de.lindele.carapp.car.repository.model.CarEntity;
import de.lindele.carapp.car.service.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {
    Page<CarEntity> findByBrand(String brand, Pageable pageable);



}
