package com.coffeeshop.restapi.service;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffeeshop.restapi.entity.customerorders.Customer;
import com.coffeeshop.restapi.repository.customerorders.CustomerRepository;

@Service
public class CustomerOrderService {
	@Autowired
	private CustomerRepository customerRepository;

	public Customer addOrderForCustomer(Customer customerEntity) {
		return wrapException(customerRepository -> customerRepository.save(customerEntity));

	}
    public Customer getAllOrderForCustomer(String customerId){
    	return wrapException(customerRepository -> customerRepository.findById(Long.valueOf(customerId)).orElseThrow(()-> new IllegalArgumentException("No such customer exists")));
    }
	
	private Customer wrapException(Function<CustomerRepository, Customer> applyFunction) {
		try {
			return applyFunction.apply(customerRepository);
		} catch (Exception ex) {
			throw ex;
		}

	}

}
