package com.coffeeshop.restapi.repository.customerorders;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeeshop.restapi.entity.products.ProductType;
import java.lang.String;
import java.util.List;

public interface  ProductTypeRepository extends JpaRepository<ProductType, Long> {
	List<ProductType> findByCategory(String category);

}
