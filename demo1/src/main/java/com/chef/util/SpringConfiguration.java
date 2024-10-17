/**
 * 
 */
package com.chef.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.chef.dao.EmployeeRepository;
import com.chef.dao.EmployeeRepositoryImpl;
import com.chef.dto.EmployeeDTO;
import com.chef.service.CustomerServiceImpl;
import com.chef.service.EmployeeServiceImpl;

/**
 * 
 */
@Configuration
@ComponentScan(basePackages = "com.chef")
public class SpringConfiguration {
	
//	@Bean(name="customerService")
//	public CustomerServiceImpl customerServiceImpl() {
//		return new CustomerServiceImpl();
//	}
//	
//	@Bean(name="employeeRepository")
//	public EmployeeRepository employeeRepositoryImpl() {
//		return new EmployeeRepositoryImpl();
//	}
//	
//	@Bean(name="employeeService")
//	public EmployeeServiceImpl employeeServiceImpl() {
//	
//		return new EmployeeServiceImpl(employeeRepositoryImpl());
//		
//	}
}
