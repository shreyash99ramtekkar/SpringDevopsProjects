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

	@Override
	/**
	 * Create customer
	 */
	public String createCustomer() {
		// TODO Auto-generated method stub
		return "Customer is successfully created";
	}

}
