package com.coffeeshop.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coffeeshop.restapi.entity.customerorders.Customer;
import com.coffeeshop.restapi.entity.customerorders.Order;
import com.coffeeshop.restapi.service.CustomerOrderService;

@RestController
@RequestMapping("/coffeeshopdemo")

public class CustomerOrderController {
	
	@Autowired
	private CustomerOrderService customerOrderService;
	
	
	
	@RequestMapping(method = RequestMethod.POST, value="/customerorder",consumes=MediaType.APPLICATION_JSON_VALUE,produces="application/json")
	public @ResponseBody  ResponseEntity<Customer> createOrder(@RequestBody Customer customer) throws Exception {
		customer = customerOrderService.addOrderForCustomer(customer);
		return  new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/customerorder/{customerId}/orders" ,produces="application/json")
	public @ResponseBody  ResponseEntity<Customer> getAllOrders(@PathVariable String customerId) throws Exception {
		Optional.of(customerId).orElseThrow(()->new IllegalArgumentException("CustomerId is either empty or invalid"));
		return  new ResponseEntity<Customer>(customerOrderService.getAllOrderForCustomer(customerId), HttpStatus.OK);
	}
	
	
   

	

}
