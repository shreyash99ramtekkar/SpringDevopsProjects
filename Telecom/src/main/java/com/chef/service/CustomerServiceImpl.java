/**
 * 
 */
package com.chef.service;

/**
 * 
 */
public class CustomerServiceImpl implements CustomerService {

	
	private CustomerRepository customerRepository;


	@Override
	public String fetchCustomer() {
		return customerRepository.fetchCustomer();
	}

	@Override
	public String createCustomer(CustomerDto dto) {
		return customerRepository.createCustomer(dto);
	}

}
