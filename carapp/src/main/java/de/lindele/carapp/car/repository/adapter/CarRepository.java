package de.lindele.carapp.car.repository.adapter;


import de.lindele.carapp.car.repository.model.CarEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {
    Page<CarEntity> findByBrand(String brand, Pageable pageable);

    Page<CarEntity> findByColor(String color, Pageable pageable);

    Optional<CarEntity> findById(Long id);

    void deleteById(Long id);

    Page<CarEntity> findAll(Pageable pageable);

    Page<CarEntity> findByBrandAndColor(String brand, String color, Pageable pageable);


}
