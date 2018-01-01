package com.coffeeshop.restapi.repository.customerorders;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeeshop.restapi.entity.customerorders.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
