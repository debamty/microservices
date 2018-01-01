package com.coffeeshop.restapi.repository.customerorders;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coffeeshop.restapi.entity.customerorders.Customer;
import java.lang.Long;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
	
	Optional<Customer> findById(Long id);

}
