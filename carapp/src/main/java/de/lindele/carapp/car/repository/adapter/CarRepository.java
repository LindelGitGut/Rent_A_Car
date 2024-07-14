package de.lindele.carapp.car.repository.adapter;

import de.lindele.carapp.car.repository.model.CarEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** Repository interface for the car entity. */
@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

  /**
   * Find all cars by brand.
   *
   * @param brand the brand
   * @param pageable the pageable
   * @return the page
   */
  Page<CarEntity> findByBrand(String brand, Pageable pageable);

  /**
   * Find all cars by color.
   *
   * @param color the color
   * @param pageable the pageable
   * @return the page
   */
  Page<CarEntity> findAllByColor(String color, Pageable pageable);

  /**
   * Find all cars by brand and color.
   *
   * @param brand the brand
   * @param color the color
   * @param pageable the pageable
   * @return the page
   */
  Page<CarEntity> findAllByBrandAndColor(String brand, String color, Pageable pageable);

  // everything below is not needed anymore because jpa repository already provides these methods

  //
  //  /**
  //   * Find car by id.
  //   * @param id
  //   * @return Optional of the car entity
  //   */
  //  Optional<CarEntity> findById(Long id);
  //
  //  /**
  //   * Delete car by id.
  //   * @param id
  //   */
  //
  //  void deleteById(Long id);
  //
  //  Page<CarEntity> findAll(Pageable pageable);

}
