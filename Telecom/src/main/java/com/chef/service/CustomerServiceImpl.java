/**
 * 
 */
package com.chef.service;

import org.springframework.stereotype.Service;

/**
 * 
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	
//	private CustomerRepository customerRepository;


	@Override
	public String fetchCustomer() {
		return "Customer Feateched";
//		return customerRepository.fetchCustomer();
	}

	@Override
	public String createCustomer() {
		return "Customer Created";
//		return customerRepository.createCustomer(dto);
	}

}
