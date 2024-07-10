package de.lindele.carapp.customer.repository.adapter;

import de.lindele.carapp.customer.repository.mapper.CustomerEntityMapper;
import de.lindele.carapp.customer.repository.model.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{

    Page<CustomerEntity> findByFirstName(String firstName, Pageable pageable);

    Page<CustomerEntity> findByLastName(String lastName, Pageable pageable);

    Page<CustomerEntity> findByFirstNameAndLastName(String firstName, String lastName, Pageable pageable);
}
