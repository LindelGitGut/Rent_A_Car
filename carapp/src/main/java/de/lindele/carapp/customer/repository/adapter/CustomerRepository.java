package de.lindele.carapp.customer.repository.adapter;

import de.lindele.carapp.customer.repository.mapper.CustomerEntityMapper;
import de.lindele.carapp.customer.repository.model.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{

    Page<CustomerEntity> findByFirstname(String firstName, Pageable pageable);

    Page<CustomerEntity> findByLastname(String lastName, Pageable pageable);

    Page<CustomerEntity> findByFirstnameAndLastname(String firstName, String lastName, Pageable pageable);
}
